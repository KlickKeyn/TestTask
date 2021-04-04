package com.testtask.service.file_service;

import com.testtask.exception.file.ImageLoadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageLoadService implements FileLoader {
    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public String load(MultipartFile file) {
        if (file == null) {
            throw new ImageLoadException("Image file is empty");
        }

        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + "." + file.getOriginalFilename();

        try {
            file.transferTo(new File(uploadPath + resultFileName));
        } catch (IOException ex) {
            throw new ImageLoadException("Failed to save image", ex);
        }

        return resultFileName;
    }
}
