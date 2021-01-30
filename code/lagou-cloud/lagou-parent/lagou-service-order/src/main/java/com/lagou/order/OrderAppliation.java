package com.lagou.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author apple
 * @date 2021/1/29 上午11:41
 * @description
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // RestTemplate+Ribbon+Hystrix
public class OrderAppliation {

    public static void main(String[] args) {

        SpringApplication.run(OrderAppliation.class,args);
    }
}
