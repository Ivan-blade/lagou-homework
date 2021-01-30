package com.lagou.goods.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author apple
 * @date 2021/1/29 下午5:38
 * @description
 */

@RestController
@RequestMapping("/goodServer")
public class ServerPortController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("port")
    public String getPort() {
        return port;
    }
}
