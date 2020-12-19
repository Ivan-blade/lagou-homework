package com.Ivan.test;

import com.Ivan.domain.Article;
import com.Ivan.mapper.ArticleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author apple
 * @date 2020/12/19 上午11:32
 * @description
 */
public class RandomTest {

    @Test
    public void random() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);

        List<Article> allArticle = mapper.displayAllArticle();

        for (Article article : allArticle) {
            System.out.println(article);
        }

        sqlSession.close();
    }

}
