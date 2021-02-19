package com.suruomo.material.dao;

import com.suruomo.material.pojo.AnalysisTask;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface AnalysisTaskMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(AnalysisTask record);

    int insertSelective(AnalysisTask record);

    AnalysisTask selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(AnalysisTask record);

    int updateByPrimaryKey(AnalysisTask record);

    List<AnalysisTask> getAll(BigDecimal id, int start, int end);

    BigDecimal getMaxId();
}