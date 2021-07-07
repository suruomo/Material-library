package com.suruomo.material.service.impl;

import com.suruomo.material.dao.AnalysisTaskMapper;
import com.suruomo.material.dao.ModelTaskMapper;
import com.suruomo.material.pojo.AnalysisTask;
import com.suruomo.material.pojo.ModelTask;
import com.suruomo.material.service.GetModeService;
import com.suruomo.material.service.GetStaticService;
import com.suruomo.material.service.ModelTaskService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: suruomo
 * @date: 2021/2/18 15:56
 * @description:
 */
@Service
public class ModelTaskServiceImpl implements ModelTaskService {
    @Resource
    private ModelTaskMapper modelTaskMapper;
    @Resource
    private AnalysisTaskMapper analysisTaskMapper;
    @Resource
    private GetModeService getModeService;
    @Resource
    private GetStaticService getStaticService;
    @Override
    public void addModel(Map<String, String> map, Long userId) {
        // 获取当前数据库最大id
        int id = modelTaskMapper.getMaxId().intValue();
        System.out.println(id);
        ModelTask modelTask=new ModelTask();
        modelTask.setId(new BigDecimal(id+1));
        modelTask.setName(map.get("name"));
        modelTask.setDescription(map.get("description"));
        modelTask.setGeometricModel(map.get("geometricModel"));
        modelTask.setFiniteElementModel(map.get("finiteElementModel"));
        modelTask.setCreateBy(new BigDecimal(userId));
        modelTask.setUpdateBy(new BigDecimal(userId));
        modelTask.setCreateTime(new Date());
        modelTask.setUpdateTime(new Date());
        modelTaskMapper.insert(modelTask);
    }

    @Override
    public void updateByPrimaryKey(ModelTask task) {
        task.setUpdateTime(new Date());
        modelTaskMapper.updateByPrimaryKey(task);
    }

    @Override
    public int addModel(Long userId) {
        // 获取当前数据库最大id
        int id = modelTaskMapper.getMaxId().intValue();
        ModelTask modelTask=new ModelTask();
        modelTask.setId(new BigDecimal(id+1));
        modelTask.setCreateBy(new BigDecimal(userId));
        modelTask.setUpdateBy(new BigDecimal(userId));
        modelTask.setCreateTime(new Date());
        modelTask.setUpdateTime(new Date());
        modelTaskMapper.insert(modelTask);
        return id+1;
    }

    @Override
    public void deleteByPrimaryKey(int id) {
        modelTaskMapper.deleteByPrimaryKey(new BigDecimal(id));
    }

    @Override
    public void deleteModelTask(String id) throws IOException {
        BigDecimal modelId=new BigDecimal(id);
        ModelTask modelTask=modelTaskMapper.selectByPrimaryKey(modelId);
        // 删除文件
        String path=modelTask.getGeometricModel();
        String[] strings=path.trim().split("/");
        // 该任务相对路径
        path=strings[0]+"/"+strings[1]+"/"+strings[2]+"/"+strings[3]+"/"+strings[4];
        File file=new File(path.substring(1));
        FileUtils.deleteDirectory(file);
        // 删除该模型任务
        modelTaskMapper.deleteByPrimaryKey(modelId);
        // 查找该模型的分析任务以及相关数据
        List<AnalysisTask> analysisTaskList=new ArrayList<>();
        analysisTaskList=analysisTaskMapper.selectByModelId(modelId);
        if (analysisTaskList.size()==0){
            return;
        }else {
            for(AnalysisTask analysisTask:analysisTaskList){
                String type=analysisTask.getType();
                String analysisId=String .valueOf(analysisTask.getId());
                switch (type) {
                    case "静力分析":
                        getStaticService.deleteAnalysisTask(analysisId);
                    case "正向模态":
                        getModeService.deleteAnalysisTask(analysisId);
                }
            }
        }
    }
}
