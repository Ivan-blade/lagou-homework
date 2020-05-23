package com.Ivan.task05;

import java.io.IOException;
import java.net.Socket;

/**
 * @author 夏殿千歌序
 * @date 2020/5/21 7:38
 * @description
 */
public class Client {

    public static void main(String[] args) {

        connect();
    }

    public static void connect() {
        Socket s = null;
        Thread th1 = null;
        Thread th2 = null;
        try {
            s = new Socket("127.0.0.1",8888);
            System.out.println("has connected to server!");
            System.out.println("input content to chat with others!");
            th1 = new ClientChatReceiveThread(s);
            th2 = new ClientChatSendThread(s);
            th1.start();
            th2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
