package com.Ivan.homework2;

/**
 * @author 夏殿千歌序
 * @date 2020/5/52 0:21
 * @description 上网套餐类
 */
// 特征：上网流量、每月资费
// 行为：显示所有套餐信息
public class InternetPackage implements InternetService{

    // 上网流量
    private double internetFlow;

    // 每月资费
    private double monthCost;

    // 显示套餐信息
    public void show() {
        System.out.println("上网流量："+getInternetFlow()+" 每月资费："+getMonthCost());
    }

    // 实现上网服务接口方法
    public void internetAction(double internetFlow,Sim s) {
        s.setInternetFlow(s.getInternetFlow()+internetFlow);
    }

    public InternetPackage() {
    }

    public InternetPackage(double internetFlow, double monthCost) {
        this.internetFlow = internetFlow;
        this.monthCost = monthCost;
    }

    public double getInternetFlow() {
        return internetFlow;
    }

    public void setInternetFlow(double internetFlow) {
        this.internetFlow = internetFlow;
    }

    public double getMonthCost() {
        return monthCost;
    }

    public void setMonthCost(double monthCost) {
        this.monthCost = monthCost;
    }
}
