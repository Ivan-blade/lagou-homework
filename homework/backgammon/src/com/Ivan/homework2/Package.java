package com.Ivan.homework2;

/**
 * @author 夏殿千歌序
 * @date 2020/5/5 20:43
 * @description 抽象套餐类
 */
public abstract class Package {

    // 每月消费
    private double monthCost;


    public void show() {
        System.out.println("每月资费："+getMonthCost());
    }

    public double getMonthCost() {
        return monthCost;
    }

    public void setMonthCost(double monthCost) {
        this.monthCost = monthCost;
    }
}
