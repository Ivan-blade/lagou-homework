package com.Ivan.task04;

import java.io.Serializable;

/**
 * @author 夏殿千歌序
 * @date 2020/5/20 13:04
 * @description
 */
public class UserMessage implements Serializable {

    private static final long serialVersionUID = -6833581642707743668L;
    private String type;
    private User user;

    public UserMessage() {
    }

    public UserMessage(String type, User user) {
        this.type = type;
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
