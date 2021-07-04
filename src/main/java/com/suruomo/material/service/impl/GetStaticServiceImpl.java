package com.suruomo.material.service.impl;

import com.suruomo.material.dao.*;
import com.suruomo.material.pojo.*;
import com.suruomo.material.service.GetStaticService;
import com.suruomo.material.utils.GetStaticResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author: suruomo
 * @Date: 2021/6/30 17:20
 * @Description:
 */
@Service
public class GetStaticServiceImpl  implements GetStaticService {
    @Resource
    private GetStaticService getStaticService;
    @Resource
    private DisplacementTranslationalMinMapper displacementTranslationalMinMapper;
    @Resource
    private DisplacementTranslationalMaxMapper displacementTranslationalMaxMapper;
    @Resource
    private DisplacementRotationalMaxMapper displacementRotationalMaxMapper;
    @Resource
    private DisplacementRotationalMinMapper displacementRotationalMinMapper;
    @Resource
    private ConstraintForceTMinMapper constraintForceTMinMapper;
    @Resource
    private ConstraintForceTMaxMapper constraintForceTMaxMapper;
    @Resource
    private ConstraintForceRMinMapper constraintForceRMinMapper;
    @Resource
    private ConstraintForceRMaxMapper constraintForceRMaxMapper;
    @Resource
    private LoadBCSMapper loadBCSMapper;
    @Resource
    private MaterialMapper materialMapper;
    @Resource
    private StressMinMapper stressMinMapper;
    @Resource
    private StressMaxMapper stressMaxMapper;
    @Resource
    private StrainMinMapper strainMinMapper;
    @Resource
    private StrainMaxMapper strainMaxMapper;

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

    @Override
    public void insertCFTMin(ConstraintForceTMin constraintForceTMin) {
        constraintForceTMinMapper.insert(constraintForceTMin);
    }

    @Override
    public void insertCFTMax(ConstraintForceTMax constraintForceTMax) {
        constraintForceTMaxMapper.insert(constraintForceTMax);
    }

    @Override
    public int getCFTMinMaxId() {
        return constraintForceTMinMapper.getMaxId();
    }

    @Override
    public int getCFTMaxMaxId() {
        return constraintForceTMaxMapper.getMaxId();
    }

    @Override
    public int getCFRMinMaxId() {
        return constraintForceRMinMapper.getMaxId();
    }

    @Override
    public void insertCFRMin(ConstraintForceRMin constraintForceRMin) {
        constraintForceRMinMapper.insert(constraintForceRMin);
    }

    @Override
    public int getCFRMaxMaxId() {
        return constraintForceRMaxMapper.getMaxID();
    }

    @Override
    public void insertCFRMax(ConstraintForceRMax constraintForceRMax) {
        constraintForceRMaxMapper.insert(constraintForceRMax);
    }

    @Override
    public int getLoadBCSMaxId() {
        return loadBCSMapper.getMaxId();
    }

    @Override
    public void insertLoadBCs(LoadBCS loadBCS) {
        loadBCSMapper.insert(loadBCS);
    }

    @Override
    public int getMaterialMaxId() {
        return materialMapper.getMaxId();
    }

    @Override
    public void insertMaterial(Material material) {
        materialMapper.insert(material);
    }

    @Override
    public int getStressMinMaxId() {
        return stressMinMapper.getMaxId();
    }

    @Override
    public void insertStressMin(StressMin stressMin) {
        stressMinMapper.insert(stressMin);
    }

    @Override
    public int getStressMaxMaxId() {
        return stressMaxMapper.getMaxId();
    }

    @Override
    public void insertStressMax(StressMax stressMax) {
        stressMaxMapper.insert(stressMax);
    }

    @Override
    public int getStrainMinMaxId() {
        return strainMinMapper.getMaxId();
    }

    @Override
    public void insertStrainMin(StrainMin strainMin) {
        strainMinMapper.insert(strainMin);
    }

    @Override
    public int getStrainMaxMaxId() {
        return strainMaxMapper.getMaxId();
    }

    @Override
    public void insertStrainMax(StrainMax strainMax) {
        strainMaxMapper.insert(strainMax);
    }

    @Override
    public void getStaticResult(BigDecimal analysisId, String resultPath) {
        String filePath = getClass().getResource(resultPath).getPath();
        GetStaticResult getStaticResult=new GetStaticResult(getStaticService);
        GetStaticResult.readLoadBCSFile(filePath,analysisId);
        GetStaticResult.readMaterialFile(filePath,analysisId);
        GetStaticResult.readDisplacementResultFile(filePath,analysisId);
        GetStaticResult.readConstraintForceResultFile(filePath,analysisId);
        GetStaticResult.readStressResultFile(filePath,analysisId);
        GetStaticResult.readStrainResultFile(filePath,analysisId);
    }
}
