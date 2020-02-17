package com.suruomo.material.service;

import com.suruomo.material.pojo.Layup;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface LayupService {
    void upload(MultipartFile file, String fileName) throws IOException;

    List<Layup> getCard();
}
