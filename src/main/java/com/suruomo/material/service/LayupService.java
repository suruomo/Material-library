package com.suruomo.material.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface LayupService {
    void upload(MultipartFile file, String fileName) throws IOException;
}
