package com.suruomo.material.dao;

import com.suruomo.material.pojo.ModeFrequencyResult;
import java.math.BigDecimal;
import java.util.List;

public interface ModeFrequencyResultMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(ModeFrequencyResult record);

    int insertSelective(ModeFrequencyResult record);

    ModeFrequencyResult selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(ModeFrequencyResult record);

    int updateByPrimaryKey(ModeFrequencyResult record);

    List<ModeFrequencyResult> getAll(BigDecimal id, int start, int end);
}