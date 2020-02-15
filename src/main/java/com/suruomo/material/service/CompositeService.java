package com.suruomo.material.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 苏若墨
 */
@Service
public interface CompositeService {
    void uploadOriginal(MultipartFile file, String fileName) throws IOException;
}
