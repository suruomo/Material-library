package com.suruomo.material.dao;

import com.suruomo.material.pojo.ConstraintForceRMin;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ConstraintForceRMinMapper {
    int insert(ConstraintForceRMin record);

    int insertSelective(ConstraintForceRMin record);

    int getMaxId();

    List<ConstraintForceRMin> getAll(BigDecimal id, int start, int end);

    void deleteByAnalysisId(BigDecimal analysisId);
}