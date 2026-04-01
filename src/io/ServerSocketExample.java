package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketExample {

    public static void main(String[] args) {
        int port = 7777;
        ServerSocket serverSocket;
        BufferedReader br = null;
        PrintWriter pw = null;
        Scanner sc = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("접속 대기중");
            Socket socket = serverSocket.accept();

            sc = new Scanner(System.in);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            while (true) {
                System.out.println("전송 받은 메세지");
                String message = br.readLine();
                if(message.equals(null)) {
                    break;
                }
                System.out.println(message);
                System.out.println("전송 할 메세지");
                String sendMessage = sc.nextLine();
                pw.println(sendMessage);
                pw.flush();

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                pw.close();
                br.close();
                sc.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
