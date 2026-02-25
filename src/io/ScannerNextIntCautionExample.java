package io;

import java.util.Scanner;

public class ScannerNextIntCautionExample {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[필수 정보 입력]");
        System.out.println("1. 이름:___________");
        String name = scanner.nextLine();

        System.out.println("2. 주민번호 앞 6자리:__________");
        int residentRegistrationNumber = scanner.nextInt();

        scanner.nextLine(); // int -> nextInt() 사용 후 남아있는 개행 문자(\n) 제거

        System.out.println("3. 전화번호:_____________ ( 앞 3자리 )");
        String phoneNumber1 = scanner.nextLine();
        System.out.println("3. 전화번호:" + phoneNumber1 + "-_________ ( 중간 4자리 )");
        String phoneNumber2 = scanner.nextLine();
        System.out.println("3. 전화번호:" + phoneNumber1 + "-" + phoneNumber2 + "-____ ( 끝 4자리 )");
        String phoneNumber3 = scanner.nextLine();

        System.out.println("[입력된 내용]");
        System.out.println("1. 이름: " + name );
        System.out.println("2. 주민번호 앞 6자리: " + residentRegistrationNumber );
        System.out.println("3. 전화번호: " + phoneNumber1 + "-" + phoneNumber2 + "-" + phoneNumber3 );


    }

}
