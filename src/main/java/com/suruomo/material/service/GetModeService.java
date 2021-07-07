package com.suruomo.material.service;

import com.suruomo.material.pojo.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @Author: suruomo
 * @Date: 2021/7/6 15:38
 * @Description:
 */
@Service
public interface GetModeService {
    int getLoadBCSMaxId();

    void insertLoadBCs(LoadBCS loadBCS);

    int getMaterialMaxId();

    void insertMaterial(Material material);

    int getFrequencyMaxId();

    void insertFrequency(ModeFrequencyResult frequencyResult);

    int getFactorsMaxId();

    void insertFactors(ModeFactors modeFactors);

    int getSpcForcesMaxId();

    void insertSpcForces(ModeMaxSpcForces spcForces);

    int getDisplacementsMaxId();

    void insertDisplacements(ModeMaxDisplacements displacements);
    /**
     * 获取模态分析结果，读取文件存入数据库
     * @param id
     * @param resultPath
     */
    void getModeResult(BigDecimal id, String resultPath);

    /**
     * 删除模态分析任务以及该任务的相关结果
     * @param id
     */
    void deleteAnalysisTask(String id) throws IOException;
}
