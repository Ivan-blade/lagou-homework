package com.lagou.dao;

import com.lagou.RunBoot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author apple
 * @date 2021/2/6 上午10:20
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBoot.class)
public class DistrictDaoTest {

    @Autowired
    DistrictDao districtDao;

    @Test
    public void testInsert(){
        districtDao.insertDist("昌平区",2);
        districtDao.insertDist("朝阳区",2);
    }

    @Test
    public void testDelete(){
        districtDao.deleteDict(564757249315045377L);
    }
}