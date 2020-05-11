package com.Ivan.task01;

import java.util.Scanner;

/**
 * @author 夏殿千歌序
 * @date 2020/5/10 17:24
 * @description 统计字符串"ABCD123!@#$%ab"中大写字母、小写字母、数字、其它字符的个数并打印
 */
public class TestMain {

    /**
     * @Description 思路：调用Character类中的方法
     */
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("please input the string:");
        // 测试 ABCD123!@#$%ab
        String str = sc.nextLine();

        int upper = 0;
        int lower = 0;
        int num = 0;
        int other = 0;

        for(int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if(Character.isUpperCase(temp)) upper++;
            else if(Character.isLowerCase(temp)) lower++;
            else if(Character.isDigit(temp)) num++;
            else other++;
        }

        System.out.println("大写字母数量为："+upper+" \n小写字母数量为："+lower+" \n数字数量为："+num+" \n其他字符数量为："+other);

    }

}
