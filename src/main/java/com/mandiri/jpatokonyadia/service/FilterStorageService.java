package com.mandiri.jpatokonyadia.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FilterStorageService {

    @Value("${file.upload.folder}")
    String folderPath;
    public void saveImage(MultipartFile multipartFile) throws IOException{

        File physicalFile = new File(folderPath+multipartFile.getOriginalFilename());
        multipartFile.transferTo(physicalFile);
    }
}
