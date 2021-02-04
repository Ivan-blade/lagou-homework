package com.Ivan;

import com.Ivan.pojo.Products;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author apple
 * @date 2021/2/3 下午5:10
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitTest {


//    @Autowired
//    private ElasticsearchTemplate template;
//
//    @Test
//    public void createIndex() {
//        template.createIndex(Products.class);
//    }
//
//    @Test
//    public void createType() {
//        template.putMapping(Products.class);
//    }
}
