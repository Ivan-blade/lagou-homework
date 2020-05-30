package com.Ivan.model;

import java.io.Serializable;

/**
 * @author 夏殿千歌序
 * @date 2020/5/26 14:04
 * @description 用户类包含姓名和密码
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1379873041322704241L;
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
