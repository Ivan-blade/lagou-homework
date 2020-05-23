package com.Ivan.task05;

import java.io.*;
import java.net.Socket;
import java.util.Random;

/**
 * @author 夏殿千歌序
 * @date 2020/5/23 11:03
 * @description
 */
public class ClientFileReceiveThread extends Thread {

    private Socket s;
    private String filename;

    public ClientFileReceiveThread(Socket s, String filename) {
        this.s = s;
        this.filename = filename;
    }

    @Override
    public void run() {
        function();
    }

    public void function() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        PrintStream ps = null;

        try {
            ps = new PrintStream(s.getOutputStream());
            bis = new BufferedInputStream(s.getInputStream());
            Random r = new Random();
            int rand = r.nextInt(500);
            bos = new BufferedOutputStream(new FileOutputStream("f:/test/temp/client/"+rand+filename));

            ps.println(filename);

            int index = 0;
            byte[] arr = new byte[1024];
            while((index = bis.read(arr)) != -1) {
                bos.write(arr,0,index);
            }
            System.out.println("receive finished");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
