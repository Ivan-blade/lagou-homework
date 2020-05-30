package com.Ivan.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 夏殿千歌序
 * @date 2020/5/26 13:10
 * @description 提供ois,oos和socket的get方法
 */
public class ClientInitClose {

    private Socket s;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public ObjectInputStream getOis() {
        return ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public Socket getS() {
        return s;
    }

    public void clientInit() throws IOException {
        s = new Socket(InetAddress.getLocalHost(),8888);
        System.out.println("client has succeeded to connect server!");

        oos = new ObjectOutputStream(s.getOutputStream());
        ois = new ObjectInputStream(s.getInputStream());
        System.out.println("client init finished!");
    }

    public void clientClose() throws IOException {
        oos.close();
        ois.close();
        s.close();
        System.out.println("client is closed");
    }
}
