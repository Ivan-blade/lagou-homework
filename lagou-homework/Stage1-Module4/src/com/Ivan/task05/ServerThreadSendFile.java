package com.Ivan.task05;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 夏殿千歌序
 * @date 2020/5/23 12:06
 * @description
 */
public class ServerThreadSendFile extends Thread {

    @Override
    public void run() {
        function();
    }

    public void function() {
        ServerSocket ss = null;
        System.out.println("file send system is running...");
        Socket s = null;

        try {
            ss = new ServerSocket(6666);
            while (true) {
                s = ss.accept();
                System.out.println(s.getPort()+" has connected");
                new ServerFileSendThread(s).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != ss) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
