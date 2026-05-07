package com.example.bigeventbackend.controller;

import com.example.bigeventbackend.pojo.User;
import com.example.bigeventbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 注册
    @PostMapping("/register")
    public String register(User user) {
        User u = userService.findByUsername(user.getUsername());
        if(u != null) {
            return "用户名已存在";
        }
        userService.register(user);
        return "注册成功";
    }

    // 登录
    @PostMapping("/login")
    public String login(User user) {
        User u = userService.findByUsername(user.getUsername());
        if(u == null) return "用户不存在";
        if(!u.getPassword().equals(user.getPassword())) return "密码错误";
        return "登录成功";
    }

    // 获取用户信息
    @GetMapping("/info/{id}")
    public User getUserInfo(@PathVariable Integer id) {
        return userService.findById(id);
    }
}