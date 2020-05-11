package com.Ivan.homework2;

/**
 * @author 夏殿千歌序
 * @date 2020/5/5 20:21
 * @description 上网套餐类
 */
// 特征：上网流量、每月资费
// 行为：显示所有套餐信息
public class InternetPackage extends Package implements InternetService{

    // 上网流量
    private double internetFlow;


    // 显示套餐信息
    @Override
    public void show() {
        super.show();
        System.out.println("上网流量："+getInternetFlow());
    }

    // 实现上网服务接口方法
    public void internetAction(double internetFlow,Sim s) {
        s.setInternetFlow(s.getInternetFlow()+internetFlow);
    }

    public InternetPackage() {
    }

    public InternetPackage(double internetFlow, double monthCost) {
        this.internetFlow = internetFlow;
        super.setMonthCost(monthCost);
    }

    public double getInternetFlow() {
        return internetFlow;
    }

    public void setInternetFlow(double internetFlow) {
        this.internetFlow = internetFlow;
    }
    
}
