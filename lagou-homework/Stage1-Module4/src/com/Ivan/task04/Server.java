package com.Ivan.task04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 夏殿千歌序
 * @date 2020/5/20 13:03
 * @description
 */
public class Server {

    // 使用对象流处理
    public static void main(String[] args) {

        ServerSocket ss = null;
        Socket s = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos= null;

        try {
            // 创建ServerSocket
            ss = new ServerSocket(8888);
            System.out.println("server is waiting...");
            s = ss.accept();
            System.out.println("clinet is connnected...");

            ois = new ObjectInputStream(s.getInputStream());
            oos = new ObjectOutputStream(s.getOutputStream());
            UserMessage um = (UserMessage) ois.readObject();

            if("admin".equals(um.getUser().getUsername()) && "123456".equals(um.getUser().getPassword())) {
                um.setType("success");
                oos.writeObject(um);
            } else {
                um.setType("fail");
                oos.writeObject(um);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != ss) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
        }


    }
}
