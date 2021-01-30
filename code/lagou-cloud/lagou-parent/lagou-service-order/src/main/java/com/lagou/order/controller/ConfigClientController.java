package com.lagou.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author apple
 * @date 2021/1/29 下午12:52
 * @description
 */

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigClientController {

    @Value("${slogan}")
    private String slogan;


    @RequestMapping("/query")
    public String getSlogan() {
        return slogan;
    }

}
