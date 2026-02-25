package variable;

public class FloatDoublePrecisionExample {

    public static void main(String[] args) {


        float var2 = 3.14f;
        double var3 = 3.14;

        float var4 = -0.1234567890123456789f;
        float var6 = 0.1234567890123456789f;
        double var5 = 0.1234567890123456789;

        System.out.println(var4);//8자리 float은 안나오는 부분에서 반올림하네
        System.out.println(var6);// float은 약 7자리 정밀도
        System.out.println(var5); // double은 약15자리 정밀도
        // 실수는 2진수로 저장되므로 오차발생
        double var7 = 8e3;// 8000 소스 코드에서 소수점이 있는 숫자 리터럴은 10진수 실수로 인식한다.
        double var9 = 5e0;//  5?
        float var8 = 3e9F; // 3000000.0
        // int v2 = 1e2; 실수에서만 지수가 붙음.

        System.out.println(var7);
        System.out.println(var9); // E 표기법은 10의 거듭제곱
        System.out.println(var8);

    }

}
