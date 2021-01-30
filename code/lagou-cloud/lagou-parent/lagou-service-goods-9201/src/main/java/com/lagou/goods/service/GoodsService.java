package com.lagou.goods.service;

import com.lagou.pojo.Goods;

import java.util.List;
import java.util.Map;

/**
 * @author apple
 * @date 2021/1/29 下午3:04
 * @description
 */

public interface GoodsService {

    Goods queryById(Integer id);

    Integer deleteById(Integer id);

    Integer updateById(Goods goods);

    Map selectAll(Integer current, Integer size);
}
