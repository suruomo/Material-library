package com.suruomo.material.dao;

import com.suruomo.material.pojo.ConstraintForceTMin;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ConstraintForceTMinMapper {
    int insert(ConstraintForceTMin record);

    int insertSelective(ConstraintForceTMin record);

    int getMaxId();

    List<ConstraintForceTMin> getAll(BigDecimal id, int start, int end);
}