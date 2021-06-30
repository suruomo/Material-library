package com.suruomo.material.service.impl;

import com.suruomo.material.dao.DisplacementRotationalMaxMapper;
import com.suruomo.material.dao.DisplacementRotationalMinMapper;
import com.suruomo.material.dao.DisplacementTranslationalMaxMapper;
import com.suruomo.material.dao.DisplacementTranslationalMinMapper;
import com.suruomo.material.pojo.DisplacementRotationalMax;
import com.suruomo.material.pojo.DisplacementRotationalMin;
import com.suruomo.material.pojo.DisplacementTranslationalMax;
import com.suruomo.material.pojo.DisplacementTranslationalMin;
import com.suruomo.material.service.DisplacementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: suruomo
 * @Date: 2021/6/30 17:20
 * @Description:
 */
@Service
public class DisplacementServiceImpl  implements DisplacementService {
    @Resource
    private DisplacementTranslationalMinMapper displacementTranslationalMinMapper;
    @Resource
    private DisplacementTranslationalMaxMapper displacementTranslationalMaxMapper;
    @Resource
    private DisplacementRotationalMaxMapper displacementRotationalMaxMapper;
    @Resource
    private DisplacementRotationalMinMapper displacementRotationalMinMapper;

    @Override
    public int getTranslationalMinMaxId() {
        return displacementTranslationalMinMapper.getMaxId();
    }

    @Override
    public void insertTranslationalMin(DisplacementTranslationalMin translationalMin) {
        displacementTranslationalMinMapper.insert(translationalMin);
    }

    @Override
    public int getTranslationalMaxMaxId() {
        return displacementTranslationalMaxMapper.getMaxId();
    }

    @Override
    public void insertTranslationalMax(DisplacementTranslationalMax translationalMax) {
        displacementTranslationalMaxMapper.insert(translationalMax);
    }

    @Override
    public int getRotationalMinMaxId() {
        return displacementRotationalMinMapper.getMaxId();
    }

    @Override
    public void insertRotationalMin(DisplacementRotationalMin rotationalMin) {
        displacementRotationalMinMapper.insert(rotationalMin);
    }

    @Override
    public int getRotationalMaxMaxId() {
        return displacementRotationalMaxMapper.getMaxId();
    }

    @Override

    public void insertRotationalMax(DisplacementRotationalMax rotationalMax) {
        displacementRotationalMaxMapper.insert(rotationalMax);
    }
}
