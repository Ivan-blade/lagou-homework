package com.Ivan.task05;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * @author 夏殿千歌序
 * @date 2020/5/21 11:25
 * @description
 */
public class ServerFileReceiveThread extends Thread{

    private Socket s;
    private List<Socket> list;

    public ServerFileReceiveThread(Socket s,List<Socket> list) {
        this.s = s;
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println("start to receive file...");
        BufferedInputStream bis = null;
        BufferedReader br = null;
        BufferedOutputStream bos = null;
        PrintStream ps = null;

        try {
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            bis = new BufferedInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());

            String name = br.readLine();
            System.out.println(name);

            File file = new File("f:/test/temp/server/"+ name);
            file.createNewFile();

            int index = 0;
            byte[] arr = new byte[1024];
            bos = new BufferedOutputStream(new FileOutputStream(file));


            while((index = bis.read(arr)) != -1) {
                bos.write(arr,0,index);
            }

            System.out.println("file has been received");
            ps.println("file has been upload!");
            for(int i = 0; i < list.size();i++) {
                ps = new PrintStream(list.get(i).getOutputStream());
                ps.println("download");
                ps.println(file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
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
