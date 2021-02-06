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
public class PayOrderDaoTest {

    @Autowired
    PayOrderDao payOrderDao;

    @Test
    public void testInsertPayOrder(){

        //user_1 为奇数,插入到 lg_order_1 数据库
        for (int i = 0; i < 5; i++) {
            //插入数据
            payOrderDao.insertPayOrder(1,"海尔电视",1);
        }

        //user_2 为偶数,插入到 lg_order_2 数据库
        for (int i = 0; i < 5; i++) {
            //插入数据
            payOrderDao.insertPayOrder(4,"王牌电视",1);
        }
    }

    @Test
    public void testFindOrderByIds(){

        List<Long> ids = new ArrayList<>();
        ids.add(564743241216294912L); //lg_order_1数据库的 order_1表
        ids.add(564743241241460737L); //lg_order_1数据库的 order_2表

        ids.add(564743241111437312L); //lg_order_2数据库的 order_1表
        ids.add(564743240398405633L); //lg_order_2数据库的 order_2表

        List<Map> mapList = payOrderDao.findOrderByIds(ids);
        System.out.println(mapList);
    }
}
