package com.suruomo.material.service.impl;

import com.suruomo.material.dao.*;
import com.suruomo.material.pojo.*;
import com.suruomo.material.service.GetModeService;
import com.suruomo.material.utils.GetModeResult;
import com.suruomo.material.utils.GetStaticResult;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @Author: suruomo
 * @Date: 2021/7/6 15:38
 * @Description:
 */
@Service
public class GetModeServiceImpl implements GetModeService {
    @Resource
    private AnalysisTaskMapper analysisTaskMapper;
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
        String filePath = resultPath.substring(1);
        GetModeResult getModeResult=new GetModeResult(getModeService);
        GetModeResult.readLoadBCSFile(filePath,analysisId);
        GetModeResult.readMaterialFile(filePath,analysisId);
        GetModeResult.readFrequencyFile(filePath,analysisId);
        GetModeResult.readFactorsFile(filePath,analysisId);
        GetModeResult.readSpcForcesFile(filePath,analysisId);
        GetModeResult.readDisplacementsFile(filePath,analysisId);
    }

    @Override
    public void deleteAnalysisTask(String id) throws IOException {
        BigDecimal analysisId=new BigDecimal(id);
        AnalysisTask analysisTask=analysisTaskMapper.selectByPrimaryKey(analysisId);
        // 删除文件
        String path=analysisTask.getResultPath();
        String[] strings=path.trim().split("/");
        // 该分析模型目相对路径
        path=strings[0]+"/"+strings[1]+"/"+strings[2]+"/"+strings[3]+"/"+strings[4]+"/"+strings[5];
        File file=new File(path.substring(1));
        FileUtils.deleteDirectory(file);
        // 删除分析任务
        analysisTaskMapper.deleteByPrimaryKey(analysisId);
        // 删除相关结果
        loadBCSMapper.deleteByAnalysisId(analysisId);
        materialMapper.deleteByAnalysisId(analysisId);
        modeFrequencyResultMapper.deleteByPrimaryKey(analysisId);
        modeFactorsMapper.deleteByPrimaryKey(analysisId);
        displacementsMapper.deleteByPrimaryKey(analysisId);
        modeMaxSpcForcesMapper.deleteByPrimaryKey(analysisId);
    }
}
