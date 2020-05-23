package com.Ivan.task02;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 夏殿千歌序
 * @date 2020/5/19 14:53
 * @description 递归删除目录
 */
public class Test {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            choose();
            System.out.println("Do you want to continue?(y/n)");
            if (!"y".equals(sc.next())) break;
        }

    }

    // 列出删除目录中的文件，确定是否删除
    public static void choose() {
        System.out.println("Please input the path of delete target:");
        String str = sc.next();
        File file = new File(str);
        System.out.println("The directory include there files, please confirm your operation:(y/n)");
        System.out.println(Arrays.toString(file.listFiles()));
        if("y".equals(sc.next())) {
            delete(file);
            System.out.println("Program is finished!");
        } else {
            System.out.println("Not delete any file.");
        }
    }

    // 递归删除
    public static void delete(File file) {
        File[] files = file.listFiles();
        for(File temp : files) {
            if(temp.isFile()) temp.delete();
            else {
                delete(temp);
                temp.delete();
            }
        }
    }
}
