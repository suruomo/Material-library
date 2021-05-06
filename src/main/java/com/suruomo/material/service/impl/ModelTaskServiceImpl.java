package com.suruomo.material.service.impl;

import com.suruomo.material.dao.ModelTaskMapper;
import com.suruomo.material.pojo.ModelTask;
import com.suruomo.material.service.ModelTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
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
}
