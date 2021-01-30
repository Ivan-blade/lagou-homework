package com.lagou.order.feign;

import com.lagou.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author apple
 * @date 2021/1/29 下午2:21
 * @description
 */

@FeignClient(name = "lagou-service-goods",fallback = GoodsFeignFallBack.class)
public interface GoodsFeign {

    @GetMapping("/goods/query/{id}")
    public Goods queryById(@PathVariable Integer id);

    @GetMapping("/goods/delete/{id}")
    public Integer deleteById(@PathVariable Integer id);

    @PostMapping("/goods/update")
    public Integer updateById(@RequestBody Goods goods);

    @GetMapping("/goods/selectAll")
    public Map selectAll(@RequestParam("current") Integer current,@RequestParam("size") Integer size);


    @GetMapping("/goodServer/port")
    public String getPort();
}
