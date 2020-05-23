package com.Ivan.task03;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 夏殿千歌序
 * @date 2020/5/19 16:36
 * @description 使用线程池将一个目录中的所有内容拷贝到另外一个目录中，包含子目录中的内容。
 */
public class Test {

    // 启用线程池
    public static void main(String[] args) {

        // test: f:/test/temp/ori/  f:/test/temp/des/
        Scanner sc = new Scanner(System.in);
        ExecutorService es = Executors.newFixedThreadPool(10);
            System.out.println("Please input the path of origin:");
            String str1 = sc.next();
            System.out.println("Please input the path of destination:");
            String str2 = sc.next();
            File file1 = new File(str1);
            File file2 = new File(str2);
            es.execute(new FileThread(file1,file2));
            es.shutdown();

    }
}
