package com.Ivan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author apple
 * @date 2021/2/3 下午7:45
 * @description
 */
@SpringBootApplication
@MapperScan("com.Ivan.mapper")
public class GoodsApplication {

    public static void main(String[] args) {

        SpringApplication.run(GoodsApplication.class,args);
    }
}
