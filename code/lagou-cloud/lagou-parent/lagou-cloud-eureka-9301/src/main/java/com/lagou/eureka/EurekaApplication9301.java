package com.lagou.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author apple
 * @date 2021/1/28 下午8:05
 * @description
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication9301 {

    public static void main(String[] args) {

        SpringApplication.run(EurekaApplication9301.class,args);
    }
}
