package com.Ivan.homework2;

/**
 * @author 夏殿千歌序
 * @date 2020/5/52 0:21
 * @description 通话套餐类
 */
// 特征：通话时长、短信条数、每月资费
// 行为: 显示所有套餐信息
public class PhonePackage implements PhoneService{

    // 通话时长
    private double phoneTime;

    // 短信数量
    private int msgNum;

    // 每月花费
    private double monthCost;

    public void show() {
        System.out.println("通话时长: "+getPhoneTime()+" 短信条数: "+getMsgNum()+" 每月资费: "+getMonthCost());
    }

    // 实现通话服务接口
    @Override
    public void phoneAction(double phoneTime,Sim s) {
        s.setPhoneTime(s.getPhoneTime()+phoneTime);
    }

    public PhonePackage() {
    }

    public PhonePackage(double phoneTime, int msgNum, double monthCost) {
        this.phoneTime = phoneTime;
        this.msgNum = msgNum;
        this.monthCost = monthCost;
    }

    public double getPhoneTime() {
        return phoneTime;
    }

    public void setPhoneTime(double phoneTime) {
        this.phoneTime = phoneTime;
    }

    public int getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(int msgNum) {
        this.msgNum = msgNum;
    }

    public double getMonthCost() {
        return monthCost;
    }

    public void setMonthCost(double monthCost) {
        this.monthCost = monthCost;
    }
}
