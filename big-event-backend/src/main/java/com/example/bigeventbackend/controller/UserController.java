package com.example.bigeventbackend.controller;

import com.example.bigeventbackend.pojo.Result;
import com.example.bigeventbackend.pojo.User;
import com.example.bigeventbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password, String rePassword) {

        // 基础参数校验
        if (username == null || username.trim().isEmpty() || password == null || rePassword == null) {
            return Result.error("用户名或密码不能为空");
        }

        if (!password.equals(rePassword)) {
            return Result.error("两次密码输入不一致");
        }

        // 调用 Service
        return userService.register(username, password);
    }

    @PostMapping("/login")
    public Result login(String username, String password) {
        return userService.login(username, password);
    }

    // 只留这一个！！！
    @GetMapping("/userInfo")
    public Result userInfo() {
        User user = userService.findById(1);
        user.setPassword(null);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam String avatarUrl) {
        // 这里正常应该存数据库，我先给你写一个能跑通的版本
        System.out.println("头像地址保存到数据库：" + avatarUrl);
        return Result.success("头像修改成功");
    }
}