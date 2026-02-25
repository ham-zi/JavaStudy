package roof;

import java.util.Scanner;

public class BankBalanceProgram {

    public static void main(String[] args) {

        boolean run = true;
        int balance = 0;
        Scanner scanner = new Scanner(System.in);

        Outter: while (run) {
            System.out.println("------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.print("번호를 입력:");
            String number = scanner.nextLine();
            switch(number) {
                case "1":
                    System.out.print("예금 금액 : ");
                    int plusMoney = scanner.nextInt();
                    balance += plusMoney;
                    scanner.nextLine();
                    break;
                case "2":
                    System.out.print("출금 금액 : ");
                    int minusMoney = scanner.nextInt();
                    balance -= minusMoney;
                    scanner.nextLine();
                    break;
                case "3":
                    System.out.println("잔고 : "+ balance);
                    break;
                default:
                    System.out.println("프로그램 종료");
                    break Outter;
            }
        }



    }

}
