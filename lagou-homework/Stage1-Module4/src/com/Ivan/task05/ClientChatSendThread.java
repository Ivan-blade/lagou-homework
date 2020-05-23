package com.Ivan.task05;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 夏殿千歌序
 * @date 2020/5/21 9:15
 * @description 用来发送信息
 */
public class ClientChatSendThread extends Thread{

    private Socket s;

    public ClientChatSendThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run () {

        Scanner sc = null;
        PrintStream ps = null;
        BufferedReader br = null;
        Socket fs = null;

        try {
            sc = new Scanner(System.in);
            ps = new PrintStream(s.getOutputStream());
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while(true) {
                String str = sc.nextLine();
                if("bye".equals(str)) {
                    break;
                } else if("upload".equals(str)) {
                    fs = new Socket("127.0.0.1",7777);
                    Thread th1 = new ClientFileSendThread(fs);
                    th1.start();
                    th1.join();
                } else if(null != str){
                    ps.println(str);
                }
            }
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
            System.out.println("client "+s.getPort()+" chat send is closed!");
            if(null != s) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != ps) ps.close();
            if(null != sc) sc.close();
        }
    }

}
