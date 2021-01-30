package com.lagou.goods.controller;

import com.lagou.goods.service.GoodsService;
import com.lagou.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author apple
 * @date 2021/1/29 下午2:29
 * @description
 */

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @GetMapping("/query/{id}")
    public Goods queryById(@PathVariable Integer id) {
        return goodsService.queryById(id);
    }

    @GetMapping("/delete/{id}")
    public Integer deleteById(@PathVariable Integer id) {
        return goodsService.deleteById(id);
    }

    @PostMapping("/update")
    public Integer deleteById(@RequestBody Goods goods) {
        return goodsService.updateById(goods);
    }

    @GetMapping("/selectAll")
    public Map selectAll(@RequestParam("current") Integer current,@RequestParam("size") Integer size) {
        System.out.println("目前匹配到熔断测试服务器...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return goodsService.selectAll(current,size);
    }



}

