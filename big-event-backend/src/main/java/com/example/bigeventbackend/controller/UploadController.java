package com.example.bigeventbackend.controller;

import com.example.bigeventbackend.pojo.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin // 解决跨域
public class UploadController {

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return Result.error("文件不能为空");
        }

        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID() + suffix;

        String path = "E:/upload/";
        File dir = new File(path);
        if (!dir.exists()) dir.mkdirs();

        file.transferTo(new File(dir, fileName));

        // ✅ 返回带 /api 的地址
        return Result.success("/api/upload/" + fileName);
    }
}