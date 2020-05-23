package com.Ivan.task03;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * @author 夏殿千歌序
 * @date 2020/5/19 16:43
 * @description
 */
public class FileThread extends Thread {

    private File ori;
    private File des;

    public FileThread(File ori, File des) {
        this.ori = ori;
        this.des = des;
    }

    @Override
    public void run () {
        copy(ori);
        System.out.println("copy is over!");
    }

    // 遍历文件夹，如果是文件直接复制，如果是目录，在目标路径中创建目录后递归
    public void copy(File file) {
        File[] files = file.listFiles();
        System.out.println(file.getAbsolutePath()+"中包含文件："+ Arrays.toString(files));
        for(File temp : files) {
            if(temp.isFile()) fileCopy(temp);
            else {
                String str = temp.getAbsolutePath().replace(ori.getAbsolutePath(),des.getAbsolutePath());
                File desFile = new File(str);
                if(!desFile.exists()) {
                    desFile.mkdir();
                    System.out.println("目录："+desFile.getAbsolutePath()+"创建成功！");
                }
                copy(temp);
            }
        }
    }

    // 复制文件存在绝对路径变换，需要将原路径中的绝对路径替换为目标路径
    public void fileCopy(File file) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            String tempStr = file.getAbsolutePath().replace(ori.getAbsolutePath(),des.getAbsolutePath());

            bos = new BufferedOutputStream(new FileOutputStream(tempStr));

            byte[] arr = new byte[1024];
            int size = 0;
            while ((size = bis.read(arr)) != -1) {
                bos.write(arr);
            }
            System.out.println(file.getAbsolutePath()+"复制完成！");
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
