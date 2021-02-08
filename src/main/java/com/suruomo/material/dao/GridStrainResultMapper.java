package com.suruomo.material.dao;

import com.suruomo.material.pojo.GridStrainResult;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface GridStrainResultMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(GridStrainResult record);

    int insertSelective(GridStrainResult record);

    GridStrainResult selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(GridStrainResult record);

    int updateByPrimaryKey(GridStrainResult record);

    List<GridStrainResult> getAll(int start, int end);
}