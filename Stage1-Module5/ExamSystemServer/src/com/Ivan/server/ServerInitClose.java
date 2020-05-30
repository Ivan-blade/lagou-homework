package com.Ivan.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 夏殿千歌序
 * @date 2020/5/26 12:49
 * @descriptionn 实现服务器的初始化和关闭
 */
public class ServerInitClose {

    private ServerSocket ss;
    private Socket s;


    public void serverInit() throws IOException{

        ss = new ServerSocket(8888);
        System.out.println("server is running...");
        while (true) {
            s = ss.accept();
            System.out.println("client "+s.getPort()+" connects to server");
            new ServerThread(s).start();
        }
    }

    public void serverClose() throws IOException {
        ss.close();
        System.out.println("server is closed!");
    }
}
