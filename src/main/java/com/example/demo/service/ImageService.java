package com.example.demo.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    String uploadImg(MultipartFile image) throws IOException;
}
