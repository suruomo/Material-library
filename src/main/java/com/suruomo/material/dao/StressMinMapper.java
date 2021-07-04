package com.suruomo.material.dao;

import com.suruomo.material.pojo.StressMin;
import com.suruomo.material.pojo.StressMinExample;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StressMinMapper {
    int countByExample(StressMinExample example);

    int deleteByExample(StressMinExample example);

    int insert(StressMin record);

    int insertSelective(StressMin record);

    List<StressMin> selectByExample(StressMinExample example);

    int updateByExampleSelective(@Param("record") StressMin record, @Param("example") StressMinExample example);

    int updateByExample(@Param("record") StressMin record, @Param("example") StressMinExample example);

    int getMaxId();

    List<StressMin> getAll(BigDecimal id, int start, int end);
}