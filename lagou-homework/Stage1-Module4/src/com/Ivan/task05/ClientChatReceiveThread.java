package com.Ivan.task05;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author 夏殿千歌序
 * @date 2020/5/21 9:52
 * @description 专门用来打印接收server发送的信息
 */
public class ClientChatReceiveThread extends Thread{

    private Socket s;

    public ClientChatReceiveThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        show();
    }

    public void show() {
        System.out.println("system is receiving...");
        BufferedReader br = null;
        BufferedInputStream bis = null;
        try {

            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str = null;
            while (true) {
                str = br.readLine();
                if(str.equals("download")) {
                    Socket temp = new Socket("127.0.0.1",6666);
                    String filename = br.readLine();
                    Thread th1 = new ClientFileReceiveThread(temp,filename);
                    th1.start();
                    th1.join();
                } else if(str != null) {
                    System.out.println(str);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("client "+s.getPort()+" socket is lost!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
