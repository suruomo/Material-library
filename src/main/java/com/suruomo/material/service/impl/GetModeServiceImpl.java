package com.suruomo.material.service.impl;

import com.suruomo.material.dao.*;
import com.suruomo.material.pojo.*;
import com.suruomo.material.service.GetModeService;
import com.suruomo.material.utils.GetModeResult;
import com.suruomo.material.utils.GetStaticResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author: suruomo
 * @Date: 2021/7/6 15:38
 * @Description:
 */
@Service
public class GetModeServiceImpl implements GetModeService {
    @Resource
    private GetModeService getModeService;
    @Resource
    private LoadBCSMapper loadBCSMapper;
    @Resource
    private MaterialMapper materialMapper;
    @Resource
    private ModeFrequencyResultMapper modeFrequencyResultMapper;
    @Resource
    private ModeFactorsMapper modeFactorsMapper;
    @Resource
    private ModeMaxSpcForcesMapper modeMaxSpcForcesMapper;
    @Resource
    private ModeMaxDisplacementsMapper displacementsMapper;

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
    public int getFrequencyMaxId() {
        return modeFrequencyResultMapper.getMaxId();
    }

    @Override
    public void insertFrequency(ModeFrequencyResult frequencyResult) {
        modeFrequencyResultMapper.insert(frequencyResult);
    }

    @Override
    public int getFactorsMaxId() {
        return modeFactorsMapper.getMaxId();
    }

    @Override
    public void insertFactors(ModeFactors modeFactors) {
        modeFactorsMapper.insert(modeFactors);
    }

    @Override
    public int getSpcForcesMaxId() {
        return modeMaxSpcForcesMapper.getMaxId();
    }

    @Override
    public void insertSpcForces(ModeMaxSpcForces spcForces) {
        modeMaxSpcForcesMapper.insert(spcForces);
    }

    @Override
    public int getDisplacementsMaxId() {
        return displacementsMapper.getMaxId();
    }

    @Override
    public void insertDisplacements(ModeMaxDisplacements displacements) {
        displacementsMapper.insert(displacements);
    }

    @Override
    public void getModeResult(BigDecimal analysisId, String resultPath) {
        String filePath = getClass().getResource(resultPath).getPath();
        GetModeResult getModeResult=new GetModeResult(getModeService);
        GetModeResult.readLoadBCSFile(filePath,analysisId);
        GetModeResult.readMaterialFile(filePath,analysisId);
        GetModeResult.readFrequencyFile(filePath,analysisId);
        GetModeResult.readFactorsFile(filePath,analysisId);
        GetModeResult.readSpcForcesFile(filePath,analysisId);
        GetModeResult.readDisplacementsFile(filePath,analysisId);
    }

    @Override
    public void deleteAnalysisTask(String id) {

    }
}
