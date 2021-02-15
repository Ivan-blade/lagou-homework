package com.Ivan;

import com.Ivan.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 夏殿千歌序
 * @date 2021/2/15 18:49
 * @description
 */
public class Solutions {

    public static void main(String[] args) {

        // int[] arr = {1,2,3};
        int[] arr = {1,2,3,2};
        System.out.println(first(arr));

        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        head.next.next = node2;
        head.next.next.next = node3;
//        head.next.next.next.next = node2;
         head.next.next.next.next = null;

        System.out.println(second(head));
    }

    // 思路：一遍哈希表，如果存在重复数字插入失败直接返回NO
    public static String first(int[] arr) {

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(!set.add(arr[i])) return "NO";
        }
        return "YES";
    }

    // 思路：快慢指针，两个指针以不同速度前进，如果有环，两个指针必定相遇
    // 否则其中一个的next节点先为null
    public static boolean second(ListNode head) {
        if(head ==  null || head.next == null) return false;
        ListNode node1 = head;
        ListNode node2 = head.next;
        while(node1 != node2) {
            if(node2 == null || node2.next == null) return false;
            node1 = node1.next;
            node2 = node2.next.next;
        }
        return true;
    }
}
