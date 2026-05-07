package com.example.bigeventbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                    // 所有接口
                .allowedOriginPatterns("*")           // 允许所有前端域名（开发阶段）
                .allowedMethods("*")                  // 允许所有请求方法
                .allowedHeaders("*")                  // 允许所有请求头
                .allowCredentials(true)               // 允许携带 cookie（以后登录要用）
                .maxAge(3600);                        // 预检请求缓存时间
    }
}