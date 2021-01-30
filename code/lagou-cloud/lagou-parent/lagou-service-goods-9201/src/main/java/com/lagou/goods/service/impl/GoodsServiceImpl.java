package com.lagou.goods.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lagou.goods.mapper.GoodsMapper;
import com.lagou.goods.service.GoodsService;
import com.lagou.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author apple
 * @date 2021/1/29 下午3:06
 * @description
 */
@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods queryById(Integer id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public Integer deleteById(Integer id) {
        return goodsMapper.deleteById(id);
    }

    @Override
    public Integer updateById(Goods goods) {
        return goodsMapper.updateById(goods);
    }

    @Override
    public Map selectAll(Integer current, Integer size) {

        Map res = new HashMap<>();
        IPage<Goods> page = new Page<>(current,size);

        // 这边好像经过这个方法操作之后原page的值会发生变更之后，方法获取的page内容会和原page内容一致
        // 这边是否进行重新赋值随意
        // page = goodsMapper.selectPage(page, null);
        goodsMapper.selectPage(page,null);

        List<Goods> records = page.getRecords();;
        res.put("total",records.size());
        res.put("list",page.getRecords());
        return res;
    }
}
