package com.Ivan.task01.entity;

import java.util.Date;

/**
 * @author apple
 * @date 2020/6/18 上午9:17
 * @description
 * CREATE TABLE phone (
 *  id INT PRIMARY KEY  AUTO_INCREMENT,
 *  pname VARCHAR(20),-- 手机名称
 *  price DOUBLE , -- 手机单价
 *  prodate DATE , -- 生产日期
 *  color VARCHAR(20) -- 颜色
 * ) ;
 */
public class Phone {

    private int id;
    private String pname;
    private double price;
    private Date prodate;
    private String color;

    public Phone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getProdate() {
        return prodate;
    }

    public void setProdate(Date prodate) {
        this.prodate = prodate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", prodate=" + prodate +
                ", color='" + color + '\'' +
                '}';
    }
}
