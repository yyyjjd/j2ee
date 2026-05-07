package com.example.bigeventbackend.service;

import com.example.bigeventbackend.mapper.CategoryMapper;
import com.example.bigeventbackend.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public void add(Category category) {
        categoryMapper.add(category);
    }

    public List<Category> list(Integer userId) {
        return categoryMapper.list(userId);
    }

    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }

    public void update(Category category) {
        categoryMapper.update(category);
    }

    public void delete(Integer id) {
        categoryMapper.delete(id);
    }
}