package variable;

public class PrintFormattingExample {
    public static void main(String[] args) {

        int value = 123;

        System.out.printf("상품의 가격:%d\n", value);
        System.out.printf("상품의 가격:%6d\n", value);
        System.out.printf("상품의 가격:%-6d\n", value);
        System.out.printf("상품의 가격:%06d\n", value);

        double area = 3.14159 * 10 * 10;
        System.out.printf("반지름이 %d인 원의 넓이:%10.2f\n",10, area); // 10인 원의 넓이= 314.159 >>> XXXX 0.16 2자리고, 반올림!
        System.out.printf("반지름이 %d인 원의 넓이:%010.2f\n",10, area); // 10인 원의 넓이= 000314.159 >>> XXXXX 0.16, 2자리였고 반올림!!!

        String name = "홍길동";
        String job = "도적";
        String hisHeight = "키";
        double height = 169.94;
        System.out.printf("%1$s의 %2$s는 %3$5.1f이고 직업은 %4$s이다.",name,hisHeight,height,job);



    }
}
