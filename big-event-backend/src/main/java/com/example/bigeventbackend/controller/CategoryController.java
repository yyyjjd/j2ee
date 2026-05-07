package com.example.bigeventbackend.controller;

import com.example.bigeventbackend.pojo.Category;
import com.example.bigeventbackend.pojo.Result;
import com.example.bigeventbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 查询分类列表
    @GetMapping
    public Result list() {
        // 固定用 userId=1，让你一定能跑通
        List<Category> list = categoryService.list(1);
        return Result.success(list);
    }

    // 添加分类
    @PostMapping
    public Result add(@RequestBody Category category) {
        // 强制给一个创建人ID，解决500错误
        category.setCreateUser(1);
        categoryService.add(category);
        return Result.success();
    }

    // 修改分类
    @PutMapping
    public Result update(@RequestBody Category category) {
        categoryService.update(category);
        return Result.success();
    }

    // 删除分类
    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        categoryService.delete(id);
        return Result.success();
    }
}