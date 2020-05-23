package com.Ivan.task05;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 夏殿千歌序
 * @date 2020/5/21 11:32
 * @description
 */
public class ClientFileSendThread extends Thread {

    private Socket s;

    public ClientFileSendThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        copy();
    }

    public void copy() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        PrintStream ps = null;
        Scanner sc = null;

        try {
            sc = new Scanner(System.in);
            System.out.println("please input the path of file: ");
            String path = sc.next();
            File file = new File(path);
            if(file.exists()) {
                ps = new PrintStream(s.getOutputStream());
                bos = new BufferedOutputStream(s.getOutputStream());
                ps.println(file.getName());
                System.out.println("start send file...");
                bis = new BufferedInputStream(new FileInputStream(file));

                int index = 0;
                byte[] arr = new byte[1024];
                while ((index = bis.read(arr)) != -1) {
                    bos.write(arr,0,index);
                    System.out.println(index);
                }
                System.out.println("succeed to send file");
            } else {
                System.out.println("this file not exist!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            
            if(null != ps) {
                ps.close();
            }
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
