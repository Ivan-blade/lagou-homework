package com.Ivan.task05;

import java.util.*;

/**
 * @author 夏殿千歌序
 * @date 2020/5/11 7:35
 * @description 为了使用比较器强行使用set和card类。。。
 * 本来只用list，写一个针对String类型的排序方法就够了。。。
 * 可能是会错意了
 */
public class TestMain {

    public static void main(String[] args) {

        // 比视频里增加了循环发牌的功能
        Scanner sc = new Scanner(System.in);
        System.out.println("input y to distribute cards:");
        String str = sc.next();
        while ("y".equals(str)) {
            // 创建牌组
            Cards cards = new Cards();

            // 发牌并使用list保存四个set，分别是三个玩家手中的牌和三张底牌牌
            List<Set<Card>> res = distribute(cards.getList());

            // 打印四个set的值
            for (int i = 0; i < 4; i++) {
                System.out.println(res.get(i));
            }
            System.out.println("input y to distribute cards:");
            str = sc.next();
        }
    }

    /**
     * @param list 传入随机牌组
     * @return 三个人的手牌和底牌
     */
    public static List<Set<Card>> distribute(List<Card> list) {

        // 比较器通过judge函数判断大小
        Comparator<Card> comparator = (Card c1,Card c2) -> {
            return judge(c1,c2);
        };

        // 返回值set1-3为手牌，set4为底牌，res返回结果
        List<Set<Card>> res = new ArrayList<>();
        Set<Card> set1 = new TreeSet<>(comparator);
        Set<Card> set2 = new TreeSet<>(comparator);
        Set<Card> set3 = new TreeSet<>(comparator);
        Set<Card> set4 = new TreeSet<>(comparator);

        // 将传入的牌组分别加入set，前十七轮发手牌，后三轮发底牌
        for(int i = 0; i < 20; i++) {
            if(i < 17) {
                set1.add(list.get(3 * i));
                set2.add(list.get(3 * i + 1));
                set3.add(list.get(3 * i + 2));
            } else set4.add(list.get(50+i-16));
        }

        // 将四个set加入list中并返回
        res.add(set1);
        res.add(set2);
        res.add(set3);
        res.add(set4);
        return res;
    }

    /**
     * @param c1 卡牌对象1
     * @param c2 卡牌对象2
     * @return int
     * @Description 优先比较卡牌字面值索引，如果字面值相等，比较两个卡牌的唯一序号
     */
    public static int judge(Card c1,Card c2) {
        int subIndex = getIndex(c1.getValue()) - getIndex(c2.getValue());
        int subNum = c2.getNum() - c1.getNum();
        return subIndex == 0 ? subNum : subIndex;
    }


    /**
     * @param s 传入卡牌字面值
     * @return int
     * @Description 返回字面值在数组中对应的索引
     */
    public static int getIndex(String s) {
        String[] temp = new String[] { "大王","小王","2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        for(int i = 0; i < temp.length;i++) {
            if(temp[i].equals(s)) return i;
        }
        return -1;
    }
}
