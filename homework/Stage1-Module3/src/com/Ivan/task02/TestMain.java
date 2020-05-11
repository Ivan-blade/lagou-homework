package com.Ivan.task02;

import java.util.Scanner;

/**
 * @author 夏殿千歌序
 * @date 2020/5/10 17:42
 * @description 编程获取两个指定字符串中的最大相同子串
 */
public class TestMain {

    /**
     * @Description 思路如提示将短的那个串进行长度依次递减的子串与较长的串比较
     */
    public static void main(String[] args) {

        // 获取两个字符串
        // 测试 asdafghjka aaasdfg
        Scanner sc = new Scanner(System.in);
        System.out.println("please input the first String:");
        String s1 = sc.nextLine();
        System.out.println("please input the second String:");
        String s2=  sc.nextLine();

        // 输出处理结果
        String res = getSub(s1, s2);
        System.out.println(res == null ? "两个字符串无相同部分" : "最大相同子串为：" + res);
    }

    /**
     * @param s1 第一个字符串
     * @param s2 第二个字符串
     * @return 最长相同子字符串或者null
     */
    public static String getSub(String s1,String s2) {

        // 判断长短字符串
        String longer = s1.length() < s2.length() ? s2 : s1;
        String shorter = s1.length() < s2.length() ? s1 : s2;
        int len = shorter.length();

        // 逐渐缩短匹配字符串长度,长度为0时终止
        while (len > 0) {
            // 根据长度将短字符串分为多个子字符串
            // 判断这些子字符串是否被包含在长字符串中
            for(int i = 0; i < shorter.length() - len + 1; i++) {
                String sub = shorter.substring(i,len+i);
                if(longer.indexOf(sub) != -1) return sub;
            }
            len--;
        }
        return null;
    }
}
