package operator;

public class UnaryOperatorExample {

    public static void main(String[] args) {

        int x = -100;
        int result1 = +x;
        int result2 = -x;
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);


        byte b = 100;
        //byte result3 = -b >> byte, short, char 타입은 연산 시 자동으로 int로 승격된다.
        int result3 = -b;
        System.out.println("result3 = " + result3);


        int y = 1;
        int z = 1;

        int result4 = ++z + 10;
        int result5 = y++ + 10;
        System.out.println("result4 = " + result4); //12
        System.out.println("result5 = " + result5); //11








    }

}
