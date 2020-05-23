package com.Ivan.task05;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

/**
 * @author 夏殿千歌序
 * @date 2020/5/21 7:42
 * @description
 */
public class ServerChatThread extends Thread{

    private Socket s;
    private List<Socket> list;


    public ServerChatThread(Socket s, List<Socket> list) {
        this.s = s;
        this.list = list;
    }

    @Override
    public void run() {
        function();
    }

    public void function() {
        BufferedReader br = null;
        PrintStream ps = null;

        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while (true) {
                String str = br.readLine();
                if("upload".equals(str)){
                    Thread th1 = new ServerFileReceiveThread(s,list);
                    th1.start();
                    th1.join();
                }
                if (null != str) {
                    String res = s.getPort()+"say: "+ str;
                    if(null != res) {
                        for (int i = 0; i < list.size(); i++) {
                            ps = new PrintStream(list.get(i).getOutputStream());
                            ps.println("upload".equals(str) ? (list.get(i).getPort()+" has uploaded file") : res);
                            System.out.println(res);
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println(s.getPort()+ " is disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if( null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if( null != ps) {
                ps.close();
            }
            System.out.println("client"+s.getPort()+"server chat thread is closed!");
            list.remove(s);
            if(null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
