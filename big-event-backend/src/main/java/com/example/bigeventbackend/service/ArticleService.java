package com.example.bigeventbackend.service;

import com.example.bigeventbackend.mapper.ArticleMapper;
import com.example.bigeventbackend.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public void add(Article article) {
        articleMapper.add(article);
    }

    public List<Article> list() {
        return articleMapper.list();
    }

    public void delete(Integer id) {
        articleMapper.delete(id);
    }

    public void update(Article article) {
        articleMapper.update(article);
    }
}