package com.lagou.goods;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lagou.goods.mapper.GoodsMapper;
import com.lagou.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author apple
 * @date 2021/1/29 下午4:18
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private GoodsMapper goodsMapper;

//    @Test
//    public void mtest() {
//        IPage<Goods> page = new Page<>(2, 2);//参数一是当前页，参数二是每页个数
//        System.out.println(page.getRecords());
//        goodsMapper.selectPage(page, null);
//        // 这边好像经过这个方法操作之后原page的值会发生变更之后，方法获取的page内容会和原page内容一致
//        // 这边赋值还是不赋值随意
//        // IPage<Goods> page = goodsMapper.selectPage(page, null);
//        System.out.println(page.getRecords());
//    }
//
//    @Test
//    public void qtest() {
//        Goods goods = goodsMapper.selectById(1);
//        System.out.println(goods);
//    }
//
//    @Test
//    public void dtest() {
//        int i = goodsMapper.deleteById(10);
//        System.out.println(i);
//    }
//
//    @Test
//    public void utest() {
//        Goods goods = goodsMapper.selectById(1);
//        goods.setPrice(999);
//        goodsMapper.updateById(goods);
//        System.out.println(goodsMapper.selectById(1));
//    }
}
