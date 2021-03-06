package com.suruomo.material.service;

import com.suruomo.material.pojo.ModelTask;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    int addModel(Long userId);

    void deleteByPrimaryKey(int id);

    /**
     * 删除模型任务以及相关数据
     * @param id
     */
    void deleteModelTask(String id) throws IOException;
}
