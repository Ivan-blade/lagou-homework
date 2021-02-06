package com.lagou.dao;

import com.lagou.RunBoot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBoot.class)
public class UsersDaoTest {

    @Autowired
    UsersDao usersDao;

    @Test
    public void testInsert(){

        for (int i = 0; i < 10 ; i++) {
            Long id = i + 100L;
            usersDao.insertUser(id,"giao桑"+i,"13511112222", "1");
        }
    }

    @Test
    public void testSelect(){

        List<Long> ids = new ArrayList<>();
        ids.add(100L);
        ids.add(101L);

        List<Map> list = usersDao.selectUserbyIds(ids);
        System.out.println(list);
    }

    // 读写分离-插入测试
    @Test
    public void testInsert02(){
        for (int i = 0; i < 5 ; i++) {
            Long id = i + 100L;
            usersDao.insertUser(id,"黑猫警长"+i,"110","2");
        }
    }
}
