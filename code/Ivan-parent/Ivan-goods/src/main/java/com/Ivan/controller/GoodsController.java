package com.Ivan.controller;

import com.Ivan.pojo.Products;
import com.Ivan.service.GoodsService;
import com.Ivan.service.impl.ConsumerServiceImpl;
import com.Ivan.service.impl.ProducerServiceImpl;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;
import java.util.Random;

/**
 * @author apple
 * @date 2021/2/3 下午7:45
 * @description
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

//    @Autowired
//    private ProducerServiceImpl producer;
//
//    @Autowired
//    private ConsumerServiceImpl consumer;

    @PostMapping("/insertGoods")
    public Integer insertGoods(@RequestBody Products products) {

        Integer integer = goodsService.insertGoods(products);

        if(integer != 0) {
            int id = (int)products.getId();
//            producer.produce(id+"");
//            consumer.consume();
            return id;
        }

        else return 0;

    }

}
