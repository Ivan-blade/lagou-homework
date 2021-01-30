package com.lagou.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author apple
 * @date 2021/1/29 下午2:26
 * @description
 */

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lagou.goods.mapper")
public class GoodsApplication {

    public static void main(String[] args) {

        SpringApplication.run(GoodsApplication.class,args);
    }
}
