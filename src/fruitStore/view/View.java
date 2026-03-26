package fruitStore.view;

import fruitStore.controller.Controller;
import fruitStore.vo.Fruit;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {
    Controller ct = new Controller();
    List<Fruit> fruits = ct.getFruits();

    public void fruitStoreMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----- fruit Counter -----");
            System.out.println(" 1 : 과일 상품 추가 ");
            System.out.println(" 2 : 과일 판매 ");
            System.out.println(" 3 : 현재 판매 목록 ");
            System.out.println(" 4 : 프로그램 종료 ");
            System.out.println("-------------------------");
            System.out.print("메뉴의 숫자 입력 >");
            String num = sc.nextLine();

            switch (num) {
                case "1": {
                    addFruit(sc);
                    break;
                }
                case "2": {
                    sellFruit(sc);
                    break;
                }
                case "3": {
                    printAllFruit();
                    break;
                }
                case "4": {
                    System.out.println("----- 프로그램 종료 -----");
                    return;
                }
                default:
                    break;
            }
        }
    }

    public void printAllFruit() {
        System.out.println("----- 진열된 과일 상품 -----");
        for (Fruit fruit : fruits) {
            if (fruit != null) {
                System.out.println(fruit.getName() + ", " + fruit.getVariety() + "품종, " + fruit.getPrice() + "원, " + fruit.getCount() + "개");
            }
        }
        System.out.println("--------------------------");
    }

    public void addFruit(Scanner sc) {
        System.out.println("[과일 상품 추가]");
        System.out.print("과일이름 > ");
        String name = sc.nextLine();
        System.out.print(" 품종 > ");
        String variety = sc.nextLine();
        System.out.print(" 가격(1EA) > ");
        String priceInput = sc.nextLine();
        System.out.print(" 개수(EA) > ");
        String countInput = sc.nextLine();
        try {
            int price = Integer.parseInt(priceInput);
            int count = Integer.parseInt(countInput);
            ct.registerFruit(name, variety,price,count);
        } catch (NumberFormatException e) {
            System.out.println("가격이나 개수에 숫자를 입력해주세요.");
        }
    }

    public void sellFruit(Scanner sc) {
        System.out.println("[과일 판매]");
        System.out.print("과일 이름 > ");
        String fruitName = sc.nextLine();
        System.out.println("과일 품종 > ");
        String fruitVariety = sc.nextLine();
        System.out.print("판매 개수 > ");
        String sellCount = sc.nextLine();

        try{ int count = Integer.parseInt(sellCount);
            Fruit theFruit = ct.findFruit(fruitName,fruitVariety);

            if (theFruit == null) {
                System.out.println("해당 과일이 없습니다.");
                return;
            }
            if (ct.availableSelling(theFruit.getCount(), count) == 1) {
                theFruit.discountFruit(count);
            } else {
                System.out.println("판매 개수가 잘못 입력되었습니다.");
            }
            System.out.println("금액 : " + theFruit.getPrice() * count + "원");
            ct.soldOutCheck(theFruit);

        } catch (NumberFormatException e) {
            System.out.println("판매 개수에 숫자를 입력해주세요.");
        }
    }

}
