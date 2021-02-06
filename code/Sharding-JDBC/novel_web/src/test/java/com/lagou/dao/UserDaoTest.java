package com.lagou.dao;

import com.lagou.NovelApplication;
import com.lagou.mapper.UserDao;
import com.lagou.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author apple
 * @date 2021/2/6 下午5:56
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NovelApplication.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void insertTest() {

        Users users = new Users();
        for(int i = 0; i < 100; i++) {
            users.setId(10000000L+i);
            users.setPassword("123456");
            users.setUsername("Ivan");
            users.setAddress("2734319366@qq.com");
            userDao.insertUsers(users);
        }
    }
}
