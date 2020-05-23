package com.Ivan.task04;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 夏殿千歌序
 * @date 2020/5/20 13:07
 * @description
 */
public class Client {

    public static void main(String[] args) {

        Socket s = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Scanner sc = new Scanner(System.in);

        try {
            s = new Socket("127.0.0.1",8888);
            System.out.println("succeed to connect to server...");
            oos = new ObjectOutputStream(s.getOutputStream());
            System.out.println("please input username: ");
            String username = sc.next();
            System.out.println("please input password: ");
            String password = sc.next();
            UserMessage um = new UserMessage("check",new User(username,password));
            oos.writeObject(um);
            ois = new ObjectInputStream(s.getInputStream());
            UserMessage um1= (UserMessage) ois.readObject();
            if("success".equals(um1.getType())) System.out.println("succeed to login!");
            else System.out.println("fail to login!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != sc) {
                sc.close();
            }
        }


    }
}
