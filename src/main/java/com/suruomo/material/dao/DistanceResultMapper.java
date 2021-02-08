package com.suruomo.material.dao;

import com.suruomo.material.pojo.DistanceResult;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface DistanceResultMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(DistanceResult record);

    int insertSelective(DistanceResult record);

    DistanceResult selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(DistanceResult record);

    int updateByPrimaryKey(DistanceResult record);

    List<DistanceResult> getAll(int start, int end);
}