package com.lagou.dao;

import com.lagou.NovelApplication;
import com.lagou.mapper.NovelDao;
import com.lagou.pojo.Novel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author apple
 * @date 2021/2/6 下午5:23
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NovelApplication.class)
public class NovelDaoTest {

    @Autowired
    NovelDao novelDao;

    @Test
    public void insertTest() {
        Novel novel = new Novel();
        novel.setId(123454532L);
        novel.setAuthor("Ivan");
        novel.setContent("this is a story");
        novel.setPic("http://www.baidu.com");
        novel.setTitle("nothing");
        novelDao.insertNovel(novel);
    }

    @Test
    public void selectTest() {

        List<Long> list = new ArrayList<>();
        list.add(123454532L);
        List<Map> res = novelDao.findNovelByIds(list);
        System.out.println(res);
    }
}
