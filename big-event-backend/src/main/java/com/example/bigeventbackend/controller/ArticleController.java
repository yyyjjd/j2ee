package com.example.bigeventbackend.controller;

import com.example.bigeventbackend.pojo.Article;
import com.example.bigeventbackend.pojo.Result;
import com.example.bigeventbackend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // ================ 修复这里！永远返回数组，不会 undefined！================
    @GetMapping
    public Result list() {
        List<Article> list = articleService.list();
        // 重点：如果为空，返回空数组，前端永远不会报错 length
        if (list == null) {
            return Result.success(new ArrayList<>());
        }
        return Result.success(list);
    }

    @PostMapping
    public Result add(@RequestBody Article article) {
        article.setCreateUser(1);
        articleService.add(article);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Article article) {
        articleService.update(article);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        articleService.delete(id);
        return Result.success();
    }
}