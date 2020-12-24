package com.Ivan.domain;

/**
 * @author apple
 * @date 2020/12/24 下午4:12
 * @description
 */
public class Customer {

    private Integer cus_id;
    private String cus_name;
    private String account;
    private String telephone;
    private String location;


    @Override
    public String toString() {
        return "Customer{" +
                "cus_id=" + cus_id +
                ", cus_name='" + cus_name + '\'' +
                ", account='" + account + '\'' +
                ", telephone='" + telephone + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Integer getCus_id() {
        return cus_id;
    }

    public void setCus_id(Integer cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
