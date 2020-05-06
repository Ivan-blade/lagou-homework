package com.Ivan.homework2;

/**
 * @author 夏殿千歌序
 * @date 2020/5/52 0:21
 * @description 用户消费信息类
 */
// 特征：统计通话时长、统计上网流量、每月消费金额
public class UserCostInfo {

    // 通话时间
    private double phoneTime;

    // 上网流量
    private double InternetFlow;

    // 每月消费
    private double monthCost;

    public UserCostInfo() {
    }

    public UserCostInfo(double phoneTime, double internetFlow, double monthCost) {
        this.phoneTime = phoneTime;
        InternetFlow = internetFlow;
        this.monthCost = monthCost;
    }

    public double getPhoneTime() {
        return phoneTime;
    }

    public void setPhoneTime(double phoneTime) {
        this.phoneTime = phoneTime;
    }

    public double getInternetFlow() {
        return InternetFlow;
    }

    public void setInternetFlow(double internetFlow) {
        InternetFlow = internetFlow;
    }

    public double getMonthCost() {
        return monthCost;
    }

    public void setMonthCost(double monthCost) {
        this.monthCost = monthCost;
    }
}
