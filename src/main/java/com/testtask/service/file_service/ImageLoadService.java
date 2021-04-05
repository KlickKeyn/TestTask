package com.testtask.service.file_service;

import com.testtask.exception.file.ImageLoadException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
public class ImageLoadService implements FileLoader {
    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public String load(MultipartFile file) {
        throwIfInvalidFile(file);

        throwIfFileIsNotJpgImage(file);

        crtDirIfItNotExist(uploadPath);

        String resultFileName = getUniqueFileName(file);

        try {
            file.transferTo(new File(uploadPath + resultFileName));
        } catch (IOException ex) {
            throw new ImageLoadException("Failed to save image", ex);
        }

        return resultFileName;
    }

    @Override
    public Boolean isContainsFile(String fileUID) {
        if (fileUID == null || fileUID.isEmpty()){
            throw new ImageLoadException("Image UID is empty");
        }

        return new File(uploadPath + fileUID).isFile();
    }

    private void throwIfFileIsNotJpgImage(MultipartFile file) {
        if (!isJpgFile(file)) {
            throw new ImageLoadException("The file does not match the image jpg format");
        }
    }

    private void throwIfInvalidFile(MultipartFile file) {
        if (file == null) {
            throw new ImageLoadException("Image file is empty");
        }
    }

    private boolean isJpgFile(MultipartFile file) {
        return file.getContentType().split("/")[1].equals("jpeg");

    }

    private String getUniqueFileName(MultipartFile file) {
        String uuidFile = UUID.randomUUID().toString();
        return uuidFile + "." + file.getOriginalFilename();
    }

    private void crtDirIfItNotExist(String dirPath) {
        File uploadDir = new File(dirPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
    }

}
