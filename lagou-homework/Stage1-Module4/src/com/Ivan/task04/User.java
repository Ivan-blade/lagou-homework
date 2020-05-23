package com.Ivan.task04;

import java.io.Serializable;

/**
 * @author 夏殿千歌序
 * @date 2020/5/20 13:04
 * @description
 */
public class User implements Serializable {

    private static final long serialVersionUID = -5038852773166450815L;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
