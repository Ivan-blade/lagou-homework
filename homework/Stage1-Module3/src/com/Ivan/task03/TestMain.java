package com.Ivan.task03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 夏殿千歌序
 * @date 2020/5/10 18:18
 * @description 准备一个 HashMap 集合，统计字符串"123,456,789,123,456"中每个数字字符串出现的次数并打印出来。
 */
public class TestMain {

    public static void main(String[] args) {

        // 获取字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("please input String ans split it with ',':");
        // 测试用：123,456,789,123,456
        String str = sc.nextLine();

        // 分割字符串返回数组
        String[] s = str.split(",");

        // Key为字符串，Value为字符串出现次数
        Map<String,Integer> map = new HashMap<>();

        // 如果已存在Key，Value加1，不存在设置key初始化value为1
        for(int i = 0; i < s.length; i++) {
            if(map.containsKey(s[i])) map.put(s[i],map.get(s[i])+1);
            else map.put(s[i],1);
        }

        // 输出键值对
        System.out.println(map);
    }
}
