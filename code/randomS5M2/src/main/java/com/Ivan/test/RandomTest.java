package com.Ivan.test;

import com.Ivan.domain.Article;
import com.Ivan.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author apple
 * @date 2020/12/22 下午1:26
 * @description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class RandomTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void randomRun() {
        Article article = new Article();
        article.setTitle("random123");
        article.setContent("123456");
        articleService.addArticle(article);
    }
}
