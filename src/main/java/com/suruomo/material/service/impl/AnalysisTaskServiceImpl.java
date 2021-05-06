package com.suruomo.material.service.impl;

import com.suruomo.material.dao.AnalysisTaskMapper;
import com.suruomo.material.pojo.AnalysisTask;
import com.suruomo.material.pojo.ModelTask;
import com.suruomo.material.service.AnalysisTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @author: suruomo
 * @date: 2021/2/19 14:22
 * @description:
 */
@Service
public class AnalysisTaskServiceImpl implements AnalysisTaskService {
    @Resource
    private AnalysisTaskMapper analysisTaskMapper;
    /**
     * 新建分析任务
     *
     * @param map
     * @param userId
     */
    @Override
    public void addAnalysis(Map<String, String> map, Long userId) {
        // 获取当前数据库最大id
        int id = analysisTaskMapper.getMaxId().intValue();
        System.out.println(id);
        AnalysisTask analysisTask=new AnalysisTask();
        analysisTask.setId(new BigDecimal(id+1));
        analysisTask.setType(map.get("type"));
        analysisTask.setModelId(new BigDecimal(map.get("modelId")));
        analysisTask.setDescription(map.get("description"));
        analysisTask.setBeforePath(map.get("beforePath"));
        analysisTask.setResultPath(map.get("resultPath"));
        analysisTask.setCreateBy(new BigDecimal(userId));
        analysisTask.setUpdateBy(new BigDecimal(userId));
        analysisTask.setCreateTime(new Date());
        analysisTask.setUpdateTime(new Date());
        analysisTaskMapper.insert(analysisTask);
    }

    @Override
    public int addAnalysis(Long userId) {
        // 获取当前数据库最大id
        int id = analysisTaskMapper.getMaxId().intValue();
        AnalysisTask analysisTask=new AnalysisTask();
        analysisTask.setId(new BigDecimal(id+1));
        analysisTask.setCreateBy(new BigDecimal(userId));
        analysisTask.setUpdateBy(new BigDecimal(userId));
        analysisTask.setCreateTime(new Date());
        analysisTask.setUpdateTime(new Date());
        analysisTaskMapper.insert(analysisTask);
        return id+1;
    }
}
