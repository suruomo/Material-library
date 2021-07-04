package com.suruomo.material.service;

import com.suruomo.material.pojo.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


/**
 * @Author: suruomo
 * @Date: 2021/6/30 17:19
 * @Description:
 */
@Service
public interface GetStaticService {
    public int getTranslationalMinMaxId();

    void insertTranslationalMin(DisplacementTranslationalMin translationalMin);

    int getTranslationalMaxMaxId();

    void insertTranslationalMax(DisplacementTranslationalMax translationalMax);

    int getRotationalMinMaxId();

    void insertRotationalMin(DisplacementRotationalMin rotationalMin);

    int getRotationalMaxMaxId();

    void insertRotationalMax(DisplacementRotationalMax rotationalMax);

    void insertCFTMin(ConstraintForceTMin constraintForceTMin);

    void insertCFTMax(ConstraintForceTMax constraintForceTMax);

    int getCFTMinMaxId();

    int getCFTMaxMaxId();

    int getCFRMinMaxId();

    void insertCFRMin(ConstraintForceRMin constraintForceRMin);

    int getCFRMaxMaxId();

    void insertCFRMax(ConstraintForceRMax constraintForceRMax);

    int getLoadBCSMaxId();

    void insertLoadBCs(LoadBCS loadBCS);

    int getMaterialMaxId();

    void insertMaterial(Material material);

    int getStressMinMaxId();

    void insertStressMin(StressMin stressMin);

    int getStressMaxMaxId();

    void insertStressMax(StressMax stressMax);

    int getStrainMinMaxId();

    void insertStrainMin(StrainMin strainMin);

    int getStrainMaxMaxId();

    void insertStrainMax(StrainMax strainMax);

    void getStaticResult(BigDecimal id, String resultPath);
}
