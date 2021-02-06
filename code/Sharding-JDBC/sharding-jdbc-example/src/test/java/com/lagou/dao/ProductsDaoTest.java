package com.lagou.dao;

import com.lagou.RunBoot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author apple
 * @date 2021/2/6 上午10:50
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBoot.class)
public class ProductsDaoTest {

    @Autowired
    ProductsDao productsDao;
    /**
     * 测试插入 * */
    @Test
    public  void testInsert(){
        for (int i = 0; i < 5; i++) { productsDao.insertProduct(100L+i,"小米手机",1888,"1");
        } }
    /**
     * 测试查询 * */
    @Test
    public void testSelect(){
        List<Map> all = productsDao.findAll();
        System.out.println(all);
    }
}
