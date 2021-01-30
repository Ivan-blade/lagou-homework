package com.lagou.order.controller;

import com.lagou.order.feign.GoodsFeign;
import com.lagou.pojo.Goods;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author apple
 * @date 2021/1/29 下午5:57
 * @description
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private GoodsFeign goodsFeign;

    @HystrixCommand(
            threadPoolKey = "getGoods"
    )
    @GetMapping("/getGoods/{id}")
    public Goods getGoods(@PathVariable Integer id) {
        Goods goods = goodsFeign.queryById(id);
        return goods;
    }

    @HystrixCommand(
            threadPoolKey = "getPort"
    )
    @GetMapping("/getPort")
    public String getGoods() {
        return goodsFeign.getPort();
    }

    @HystrixCommand(
            threadPoolKey = "deleteGoods"
    )
    @GetMapping("/deleteGoods/{id}")
    public Integer deleteGoods(@PathVariable Integer id) {
        Integer i = goodsFeign.deleteById(id);
        return i;
    }

    @HystrixCommand(
            threadPoolKey = "updateGoods"
    )
    @PostMapping("/updateGoods")
    public Integer updateGoods(@RequestBody Goods goods) {
        Integer i = goodsFeign.updateById(goods);
        return i;
    }

    @HystrixCommand(
            threadPoolKey = "gainGoods"
    )
    @GetMapping("/gainGoods")
    public Map getGoods(@RequestParam("current") Integer current,@RequestParam("size") Integer size) {
        Map map = goodsFeign.selectAll(current,size);
        return map;
    }

}
