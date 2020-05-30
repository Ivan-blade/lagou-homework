package com.Ivan.model;

import java.io.Serializable;

/**
 * @author 夏殿千歌序
 * @date 2020/5/30 9:37
 * @description 分数类，主要包含学生名和分数
 */
public class Point implements Serializable {

    private static final long serialVersionUID = -6360519982437553939L;


    private String name;
    private int point;

    public Point(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Point{" +
                "name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
