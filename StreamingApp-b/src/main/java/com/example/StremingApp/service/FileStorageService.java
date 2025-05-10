package com.example.StremingApp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@Service
public class FileStorageService {

    public String saveVideo(MultipartFile file, String subDir) throws IOException {
        String uploadDir = "C:/videos/" + subDir + "/";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String filePath = uploadDir + file.getOriginalFilename();
        File dest = new File(filePath);
        file.transferTo(dest);

        return filePath;
    }
}
