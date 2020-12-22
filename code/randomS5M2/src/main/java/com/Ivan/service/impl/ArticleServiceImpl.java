package com.Ivan.service.impl;

import com.Ivan.dao.ArticleDao;
import com.Ivan.domain.Article;
import com.Ivan.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author apple
 * @date 2020/12/21 下午11:38
 * @description
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public void addArticle(Article article) {

        articleDao.addArticle(article);
    }

}
