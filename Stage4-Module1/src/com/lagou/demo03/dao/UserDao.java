package com.lagou.demo03.dao;

import com.lagou.demo03.bean.Student;
import com.lagou.demo03.bean.User;

import java.util.List;

public interface UserDao {

    // 登陆
    User userLogin(User user);

}
