package com.background.articleService.service.impl;

import com.background.articleService.entity.Article;
import com.background.commonSecurity.exception.ArticleNotFoundException;
import com.background.articleService.mapper.ArticleMapper;
import com.background.articleService.service.ArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public boolean createArticle(Article article) {
        int inserted=0;
        try{
            inserted = articleMapper.insert(article);
        }catch (Exception e){
            log.error(e.getMessage());
        }

        return inserted > 0;
    }

    @Override
    public boolean updateArticle(Article article) {
        int updated = articleMapper.updateById(article);
        if (updated == 0) {
            throw new ArticleNotFoundException("Article not found for id: " + article.getId());
        }
        return true;
    }

    @Override
    public boolean deleteArticleById(Long articleId) {
        int deleted = articleMapper.deleteById(articleId);
        if (deleted == 0) {
            throw new ArticleNotFoundException("Article not found for id: " + articleId);
        }
        return true;
    }

    @Override
    public Article findArticleById(Long articleId) {
        Article article = articleMapper.selectById(articleId);
        if (article == null) {
            throw new ArticleNotFoundException("Article not found for id: " + articleId);
        }
        return article;
    }

    @Override
    public List<Article> findAllArticles() {
        return articleMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<Article> findHotArticles(int limit) {
        Page<Article> page = new Page<>(1, limit);
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("views"); // Assuming 'views' column exists for popularity
        return articleMapper.selectPage(page, queryWrapper).getRecords();
    }
}
