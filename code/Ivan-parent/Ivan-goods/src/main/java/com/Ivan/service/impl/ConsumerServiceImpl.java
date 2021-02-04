package com.Ivan.service.impl;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Properties;

/**
 * @author apple
 * @date 2021/2/4 上午1:04
 * @description
 */

@Service
public class ConsumerServiceImpl {

    public void consume() {
//        String topic = "product";
//        Properties p = new Properties();
//        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                "192.168.200.30:9092,192.168.200.30:9093,192.168.200.30:9094");
//        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        //指定组名
//        p.put(ConsumerConfig.GROUP_ID_CONFIG, "product");
//        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(p);
//        kafkaConsumer.subscribe(Collections.singletonList(topic));// 订阅消息
//
//        while (true) {
//            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
//                System.out.println(String.format("topic:%s,offset:%d,消息:%s", record.topic(), record.offset(), record.value()));
//            }
//        }

    }
}
