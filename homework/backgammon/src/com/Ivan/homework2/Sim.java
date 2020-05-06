package com.Ivan.homework2;

/**
 * @author 夏殿千歌序
 * @date 2020/5/52 0:20
 * @description 手机卡类
 */
// 特征：卡类型、卡号、用户名、密码、账户余额、通话时长(分钟)、上网流量
// 行为：显示（卡号 + 用户名 + 当前余额）
public class Sim {

    // 卡类型
    private String cardType;

    // 卡号
    private String cardId;

    // 用户名
    private String name;

    // 密码
    private String password;

    // 账户余额
    private double rest;

    // 通话时间
    private double phoneTime;

    // 无参构造函数
    public Sim() {
    }

    // 有参构造函数
    public Sim(String cardType, String cardId, String name, String password, double rest, double phoneTime, double internetFlow) {
        this.cardType = cardType;
        this.cardId = cardId;
        this.name = name;
        this.password = password;
        this.rest = rest;
        this.phoneTime = phoneTime;
        this.internetFlow = internetFlow;
    }

    public double getInternetFlow() {
        return internetFlow;
    }

    public void setInternetFlow(double internetFlow) {
        this.internetFlow = internetFlow;
    }

    private double internetFlow;

    public void show() {
        System.out.println("卡号"+getCardId()+" 所属用户："+getName()+" 当前余额为："+getRest());
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {

        this.cardType = cardType;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRest() {
        return rest;
    }

    public void setRest(double rest) {
        this.rest = rest;
    }

    public double getPhoneTime() {
        return phoneTime;
    }

    public void setPhoneTime(double phoneTime) {
        this.phoneTime = phoneTime;
    }


}
