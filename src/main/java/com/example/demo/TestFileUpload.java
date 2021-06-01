package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
@Slf4j
@RequestMapping("a")
public class TestFileUpload {

    @PostMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest req) {
        String realPath = req.getSession().getServletContext().getRealPath("/uploadFile");
        if (file == null) {
            return "上传失败，未选择文件";
        }
        String fileName = file.getOriginalFilename();
        log.info("文件名：" + fileName);
        return "上传失败";
    }

    @GetMapping("test")
    public String test(HttpServletRequest req) {
        return "test";
    }
}
