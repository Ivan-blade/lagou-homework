package com.Ivan.homework2;

import java.util.Arrays;

/**
 * @author 夏殿千歌序
 * @date 2020/5/52 0:38
 * @description 卡类
 */
public enum CardType {

    BIG("大卡"),
    SMALL("小卡"),
    MICRO("微型卡");

    private final String type;

    CardType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
