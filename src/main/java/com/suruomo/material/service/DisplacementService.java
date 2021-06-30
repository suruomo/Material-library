package com.suruomo.material.service;

import com.suruomo.material.pojo.DisplacementRotationalMax;
import com.suruomo.material.pojo.DisplacementRotationalMin;
import com.suruomo.material.pojo.DisplacementTranslationalMax;
import com.suruomo.material.pojo.DisplacementTranslationalMin;
import org.springframework.stereotype.Service;


/**
 * @Author: suruomo
 * @Date: 2021/6/30 17:19
 * @Description:
 */
@Service
public interface DisplacementService {
    public int getTranslationalMinMaxId();

    void insertTranslationalMin(DisplacementTranslationalMin translationalMin);

    int getTranslationalMaxMaxId();

    void insertTranslationalMax(DisplacementTranslationalMax translationalMax);

    int getRotationalMinMaxId();

    void insertRotationalMin(DisplacementRotationalMin rotationalMin);

    int getRotationalMaxMaxId();

    void insertRotationalMax(DisplacementRotationalMax rotationalMax);
}
