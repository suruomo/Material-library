package com.suruomo.material.dao;

import com.suruomo.material.pojo.ConstraintForceRMax;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ConstraintForceRMaxMapper {
    int insert(ConstraintForceRMax record);

    int insertSelective(ConstraintForceRMax record);

    int getMaxID();

    List<ConstraintForceRMax> getAll(BigDecimal id, int start, int end);

    void deleteByAnalysisId(BigDecimal analysisId);
}