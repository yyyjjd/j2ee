package com.example.bigeventbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 当访问路径包含 /upload/ 时，去磁盘 E:/upload/ 寻找资源
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:E:/upload/");
    }
}