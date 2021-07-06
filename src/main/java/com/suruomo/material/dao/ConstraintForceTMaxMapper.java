package com.suruomo.material.dao;

import com.suruomo.material.pojo.ConstraintForceTMax;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ConstraintForceTMaxMapper {
    int insert(ConstraintForceTMax record);

    int insertSelective(ConstraintForceTMax record);

    int getMaxId();

    List<ConstraintForceTMax> getAll(BigDecimal id, int start, int end);

    void deleteByAnalysisId(BigDecimal analysisId);
}