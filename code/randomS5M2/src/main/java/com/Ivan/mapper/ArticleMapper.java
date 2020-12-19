package com.Ivan.mapper;

import com.Ivan.domain.Article;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/19 上午12:20
 * @description
 */
public interface ArticleMapper {

    List<Article> displayAllArticle();

    List<Article> displayAllArticle2();
}
