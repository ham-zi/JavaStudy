package inheritance;

public class StringExample {

    public static void main(String[] args) {

        String str1 = "나를_죽이지_못한_고통은_나를_더_강하게_만든다.";

        //charAt() : char
        System.out.print(str1.charAt(0));
        System.out.println(str1.charAt(1));
        System.out.println(str1.charAt(10));
        System.out.println(str1.charAt(13));
        // char형이라 연산자 쓰면 int형으로 형변환됨
        System.out.println(str1.charAt(0)+str1.charAt(1));



        //subString(int beginIndex, int endIndex) : String
        System.out.println(str1.substring(10)); // 고통은_나를_더_강하게_만든다.
        System.out.println(str1.substring(10,13)); // 고통은
        // 마지막 인덱스는 비포함


        //indexOf(String) : int
        String str2 = "dasan@home.com";
        System.out.println(str1.indexOf("고통은"));
        System.out.println(str1.indexOf('나',5));
        System.out.println(str2.indexOf('@'));

        //lastIndexOf(String) : int
        String str3 = "asdf.jpg";
        System.out.println(str3.lastIndexOf('.')); //
        System.out.println(str3.substring(0,4)); // lastIndexOf+subString => 파일명
        System.out.println(str3.substring(str3.lastIndexOf('.')+1,str3.length())); // 확장자명


        //toCharArray() : char[]
        char[] chars = str1.toCharArray();
        for (char c : chars) {
            System.out.println(c);
        }

        String char4 = String.valueOf(chars);
        System.out.println(char4);
    }

}
