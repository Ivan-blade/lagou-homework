package com.Ivan.server;

import com.Ivan.model.User;

import java.io.FileInputStream;
import java.util.List;

/**
 * @author 夏殿千歌序
 * @date 2020/5/26 14:33
 * @description
 */
public class ServerDao {

    /**
     * 编程实现管理员账号和密码的校验并将结果返回出去
     * @param user
     * @return boolean
     */
    public static boolean serverManagerCheck(User user) {
        if ("admin".equals(user.getName()) && "123456".equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    /**
     * @Description 实现普通用户登录
     * @param user
     * @param list
     * @return boolean
     */
    public static boolean serverUserCheck(User user, List<User> list) {
        for(User temp : list) {
            if(temp.getName().equals(user.getName()) && temp.getPassword().equals(user.getPassword())) return true;
        }
        return false;
    }
}
