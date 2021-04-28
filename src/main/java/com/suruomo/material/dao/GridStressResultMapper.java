package com.suruomo.material.dao;

import com.suruomo.material.pojo.GridStressResult;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface GridStressResultMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(GridStressResult record);

    int insertSelective(GridStressResult record);

    GridStressResult selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(GridStressResult record);

    int updateByPrimaryKey(GridStressResult record);

    List<GridStressResult> getAll(BigDecimal id, int start, int end);
}