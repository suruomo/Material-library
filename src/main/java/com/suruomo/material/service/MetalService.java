package com.suruomo.material.service;

import com.suruomo.material.pojo.MetalInput;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author 苏若墨
 */
@Service
public interface MetalService {
    void uploadOriginal(MultipartFile file, String fileName) throws IOException;

    List<MetalInput> getAll();


}
