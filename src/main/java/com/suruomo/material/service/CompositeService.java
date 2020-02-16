package com.suruomo.material.service;

import com.suruomo.material.pojo.CompositeInput;
import com.suruomo.material.pojo.CompositeOut;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author 苏若墨
 */
@Service
public interface CompositeService {
    void uploadOriginal(MultipartFile file, String fileName) throws IOException;

    List<CompositeInput> getOriginal();

    void uploadCard(MultipartFile file, String fileName) throws IOException;

    List<CompositeOut> getCard();
}
