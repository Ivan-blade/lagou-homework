package com.Ivan.task05;

import java.io.*;
import java.net.Socket;

/**
 * @author 夏殿千歌序
 * @date 2020/5/23 11:11
 * @description
 */
public class ServerFileSendThread extends Thread {

    private Socket s;

    public ServerFileSendThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        function();
    }

    public void function() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        BufferedReader br = null;

        try {
            bos = new BufferedOutputStream(s.getOutputStream());
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String filename = br.readLine();
            bis = new BufferedInputStream(new FileInputStream("f:/test/temp/server/"+filename));

            int index = 0;
            byte[] arr = new byte[1024];

            while ((index = bis.read(arr)) != -1) {
                bos.write(arr,0,index);
            }
            System.out.println("client has received file");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
