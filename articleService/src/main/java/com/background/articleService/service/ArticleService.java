package com.background.articleService.service;

import com.background.articleService.entity.Article;
import java.util.List;

public interface ArticleService {
    boolean createArticle(Article article);
    boolean updateArticle(Article article);
    boolean deleteArticleById(Long articleId);
    Article findArticleById(Long articleId);
    List<Article> findAllArticles();
    List<Article> findHotArticles(int limit);
}
