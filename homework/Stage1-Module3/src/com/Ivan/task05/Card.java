package com.Ivan.task05;

/**
 * @author 夏殿千歌序
 * @date 2020/5/11 8:36
 * @description 卡牌类表示单张卡牌
 */
public class Card {

    // 唯一序号，对应加入list的次序，防止TreeSet不保存相同value的卡牌
    private int num;
    // 字面值（2-A，小王，大王）
    private String value;

    public Card() {
    }

    public Card(int num, String value) {
        this.num = num;
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " ";
    }
}
