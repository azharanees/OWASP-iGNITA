package com.azhar.scannerrestapi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileService {

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    public Path uploadFile(MultipartFile file) {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        try {
            Path copyLocation = Paths
                    .get(uploadDir + File.separator +timeStamp +StringUtils.cleanPath(file.getOriginalFilename()));

            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            return  copyLocation;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename()
                    + ". Please try again!");
        }
    }
}
