package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketExample {

    public static void main(String[] args) {

        int port = 7777;
        String ip = "172.0.0.1";

        Socket socket = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        Scanner sc = null;

        try {
            socket = new Socket(ip, port);

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());
            sc = new Scanner(System.in);
            System.out.println("종료를 원하시면 exit 입력");

            while (true) {
                System.out.println("보낼 메세지 >");
                String sandMessage = sc.nextLine();
                pw.write(sandMessage);
                pw.flush();
                System.out.println("받은 메세지 > ");
                String message = br.readLine();
                System.out.println(message);

                if (sandMessage.equals("exit")){
                    return;
                }

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
                pw.close();
                sc.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }



}
