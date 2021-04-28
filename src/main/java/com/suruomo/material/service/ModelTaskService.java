package com.suruomo.material.service;

import com.suruomo.material.pojo.ModelTask;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: suruomo
 * @date: 2021/2/18 15:56
 * @description:
 */
@Service
public interface ModelTaskService {
    /**
     * 新建模型任务
     * @param map
     * @param userId
     */
    void addModel(Map<String, String> map, Long userId);

    void updateByPrimaryKey(ModelTask task);
}
