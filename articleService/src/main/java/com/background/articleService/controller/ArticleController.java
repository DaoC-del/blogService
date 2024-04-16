package com.background.articleService.controller;

import com.background.articleService.dto.ArticleDTO;
import com.background.articleService.entity.Article;
import com.background.articleService.service.ArticleService;
import com.background.commonSecurity.util.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/create")
    public ResponseEntity<String> createArticle(@RequestBody ArticleDTO articleDTO) {
        Article article = convertToEntity(articleDTO);
        articleService.createArticle(article);
        return ResponseEntity.ok("Article created successfully");
    }

    @GetMapping("/hot")
    public ResponseEntity<List<Article>> getHotArticles() {
        List<Article> articles = articleService.findHotArticles(10); // Get top 10 hot articles
        return ResponseEntity.ok(articles);
    }

    // Add other endpoints as needed for update, delete, etc.

    private Article convertToEntity(ArticleDTO articleDTO) {
        return MappingUtils.map(articleDTO, Article.class);
    }
}
