package com.Ivan.task05;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @author 夏殿千歌序
 * @date 2020/5/23 9:53
 * @description
 */
public class ServerThreadChat extends Thread {

    private List<Socket> list;

    public ServerThreadChat(List<Socket> list) {
        this.list = list;
    }

    @Override
    public void run() {
        function();
    }

    public void function() {
        ServerSocket ss = null;
        Socket s = null;

        try {
            ss = new ServerSocket(8888);
            System.out.println("chat server is waiting...");
            while(true) {
                s = ss.accept();
                System.out.println(s.getPort()+" has connected chat system!");
                list.add(s);
                new ServerChatThread(s,list).start();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != ss) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("serversocket is closed!");
        }
    }
}
