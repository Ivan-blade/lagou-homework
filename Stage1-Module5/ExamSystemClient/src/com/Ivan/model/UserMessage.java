package com.Ivan.model;

import java.io.Serializable;

/**
 * @author 夏殿千歌序
 * @date 2020/5/26 14:07
 * @description
 */
public class UserMessage implements Serializable {

    private static final long serialVersionUID = 5005707502193794214L;

    private String type;
    private User user;

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

    public UserMessage() {
    }

    public UserMessage(String type, User user) {
        this.type = type;
        this.user = user;
    }
}
