package com.suruomo.material.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: suruomo
 * @date: 2021/2/19 14:21
 * @description:
 */
@Service
public interface AnalysisTaskService {
    /**
     * 新建分析任务
     * @param map
     * @param userId
     */
    void addAnalysis(Map<String, String> map, Long userId);
}
