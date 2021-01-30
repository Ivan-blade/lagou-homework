package com.lagou.order.feign;

import com.lagou.pojo.Goods;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author apple
 * @date 2021/1/29 下午2:23
 * @description
 */

@Component
public class GoodsFeignFallBack implements GoodsFeign {

    @Override
    public Goods queryById(Integer id) {
        return null;
    }

    @Override
    public Integer deleteById(Integer id) {
        return -1;
    }

    @Override
    public Integer updateById(Goods goods) {
        return -1;
    }

    @Override
    public Map selectAll(Integer current, Integer size) {
        return null;
    }

    @Override
    public String getPort() {
        return "该服务器已宕机...";
    }
}
