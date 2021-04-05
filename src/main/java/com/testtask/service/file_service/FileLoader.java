package com.testtask.service.file_service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface FileLoader {
    String load(MultipartFile file) throws IOException;

    Boolean isContainsFile(String fileUID);
}
