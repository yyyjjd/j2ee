package com.example.bigeventbackend.service;

import com.example.bigeventbackend.pojo.Result;
import com.example.bigeventbackend.pojo.User;

public interface UserService {
    Result register(String username, String password);
    Result login(String username, String password);

    Result findUserByUsername(String username);

    User findById(Integer id);

    // 新增：更新用户信息（修改资料用）
    void update(User user);
}