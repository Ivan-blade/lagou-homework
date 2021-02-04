package com.Ivan.service.impl;

import com.Ivan.mapper.GoodsMapper;
import com.Ivan.pojo.Products;
import com.Ivan.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author apple
 * @date 2021/2/3 下午7:46
 * @description
 */

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Integer insertGoods(Products products) {
        return goodsMapper.insert(products);
    }
}
