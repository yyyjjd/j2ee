package com.example.bigeventbackend.service.impl;

import com.example.bigeventbackend.mapper.UserMapper;
import com.example.bigeventbackend.pojo.Result;
import com.example.bigeventbackend.pojo.User;
import com.example.bigeventbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result register(String username, String password) {
        // 1. 检查用户名是否已存在
        User existUser = userMapper.findByUsername(username);
        if (existUser != null) {
            return Result.error("用户名已被占用");
        }

        // 2. 创建新用户
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);           // 实际项目中必须加密！
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        // 3. 插入数据库
        userMapper.add(user);
        return Result.success();
    }

    @Override
    public Result login(String username, String password) {
        // 后面再完善登录逻辑（目前先简单返回成功）
        return Result.success("登录成功");
    }

    // UserServiceImpl.java 新增方法
    @Override
    public Result findUserByUsername(String username) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            return Result.error("用户不存在");
        }
        return Result.success(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}