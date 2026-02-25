package variable;

public class TypePromotionAndCastingExample {

    // byte - short - int - long - float - double
    public static void main(String[] args) {


        int intValue = 10;
        byte byteValue = (byte) intValue;
        System.out.println("byteValue = " + byteValue);

        byte x = 10;
        byte y = 127;
        int result = x + y;
        System.out.println("result = " + result);
        byte result1 = 20 + 10;
        System.out.println("result1 = " + result1);

        byte value1 = 10;
        short value2 = 128;
        int value3 = 16;
        long value4 = 1000;
        long result2 = value1 + value2 + value3 + value4;
        System.out.println("result2 = " + result2);


        int q = 1;
        int w = 2;
        double resultQW = (double) q / w;
        System.out.println("resultQW = " + resultQW);

        char charValue1 = 'A';
        char charValue2 = 1;
        // char charValeu3 = charValue1 + charValue2; 컴파일 에러
        int intValue2 = charValue1 + charValue2;

        System.out.println("intValue2 = " + intValue2);
        System.out.println("intValue2 = " + (char) intValue2);

        int intValue3 = 10;
        int intValue4 = intValue3 / 4;
        System.out.println("intValue4 = " + intValue4);

        int intValue5 = 10;
        //int intValue6 = 10 / 4.0;
        double intValue6 = 10 / 4.0;
        System.out.println("intValue6 = " + intValue6);


        int a1 = Integer.parseInt("10");
        double a2 = Double.parseDouble("3.14");
        boolean a3 = Boolean.parseBoolean("false");

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        String str1 = String.valueOf(a1);
        String str2 = String.valueOf(a2);
        String str3 = String.valueOf(a3);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
/*
        byte byte1 = 10;
        char char1 = 'a';
        short short1 = 0;
        System.out.println(short1 = char1); 컴파일 에러

        String strValue = "A";
        char a = Integer.parseInt(strValue); 컴파일 에러
    }*/
        /*
        byte byte2 = 10;
        byte byte3 = byte2 + byte2; 컴파일 에러
    */

        char c1 = 'a';
        char c3 = 'b';
        int c2 = c1 + 1;
        System.out.println("(char)c2 = " + (char) c2);

        double var1 = 3.5;
        double var2 = 2.7;
        int resulttt = (int) (var1 + var2);
        System.out.println("resulttt = " + resulttt);

        double var3 = 3.5;
        double var4 = 2.7;
        int result111 = (int) var1 + (int) var2;
        System.out.println("resul111 = " + result111); //5? 헉 6이네?! -> result 변수명 실수 -> 가독성좋은 변수명으로 정할것

        /* 합산이 9가 나오도록 해야함 */
        String var10 = "3.9";
        long var11 = 2L;
        float var12 = 1.8f;
        double var13 = 2.5;
        System.out.println(Double.parseDouble(var10));
        int result11 =(int)( Double.parseDouble(var10) +  var13) + (int) var11 + (int) var12; // double을 이용
        System.out.println("result11 = " + result11); // double끼리 연산해서 소수점 계산 이용하여 결과값을 맞추고, 나머지는 int로 변경해서 연산




    }

}
