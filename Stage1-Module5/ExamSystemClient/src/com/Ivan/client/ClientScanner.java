package com.Ivan.client;

import java.util.Scanner;

/**
 * @author 夏殿千歌序
 * @date 2020/5/26 13:48
 * @description
 */
public class ClientScanner {

    private static Scanner sc = new Scanner(System.in);

    public static Scanner getSc() {
        return sc;
    }

    public  static void closeScanner() {
        sc.close();
    }
}
