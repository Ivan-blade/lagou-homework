package com.Ivan.service.impl;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * @author apple
 * @date 2021/2/4 上午1:02
 * @description
 */

@Service
public class ProducerServiceImpl {



    public void produce(String id) {

//        String topic = "product";
//        Properties properties = new Properties();
//        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                "192.168.200.30:9092,192.168.200.30:9093,192.168.200.30:9094"); //网络传输,对key和value进行序列化
//        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        //创建消息生产对象，需要从properties对象或者从properties文件中加载信息
//        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
//        try {
//            //将消息内容封装到ProducerRecord中
//            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, id);
//            kafkaProducer.send(record);
//            System.out.println("id发送成功: " + id);
//        } finally {
//            kafkaProducer.close();
//        }
    }
}
