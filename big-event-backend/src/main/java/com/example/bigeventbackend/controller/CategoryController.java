package com.example.bigeventbackend.controller;

import com.example.bigeventbackend.pojo.Category;
import com.example.bigeventbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 新增分类
    @PostMapping
    public String add(@RequestBody Category category) {
        category.setCreateUser(1); // 这里先写死用户ID，后续可以根据登录用户获取
        categoryService.add(category);
        return "新增成功";
    }

    // 分类列表
    @GetMapping
    public List<Category> list() {
        return categoryService.list(1); // 同样先写死用户ID
    }

    // 获取分类详情
    @GetMapping("/{id}")
    public Category detail(@PathVariable Integer id) {
        return categoryService.findById(id);
    }

    // 更新分类
    @PutMapping
    public String update(@RequestBody Category category) {
        categoryService.update(category);
        return "更新成功";
    }

    // 删除分类
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        categoryService.delete(id);
        return "删除成功";
    }
}