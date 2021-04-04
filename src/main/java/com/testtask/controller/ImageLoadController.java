package com.testtask.controller;

import com.testtask.service.file_service.ImageLoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/load")
@RequiredArgsConstructor
public class ImageLoadController {
    private final ImageLoadService imageLoadService;

    @PostMapping("/image")
    public String loadImage(@RequestParam("file") MultipartFile file) {
        return imageLoadService.load(file);
    }
}
