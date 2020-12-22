package com.Ivan.dao.impl;

import com.Ivan.dao.ArticleDao;
import com.Ivan.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author apple
 * @date 2020/12/22 上午1:02
 * @description
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addArticle(Article article) {

        String sql = "insert into t_article values(null,?,?)";

        jdbcTemplate.update(sql,article.getTitle(),article.getContent());

    }
}
