package com.background.articleService.mapper;

import com.background.articleService.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    // 这里可以添加自定义的数据库操作方法，但由于BaseMapper已提供大部分CRUD操作，可能不需要额外定义
}
