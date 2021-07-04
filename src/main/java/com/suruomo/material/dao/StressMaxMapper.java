package com.suruomo.material.dao;

import com.suruomo.material.pojo.StressMax;
import com.suruomo.material.pojo.StressMaxExample;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StressMaxMapper {
    int countByExample(StressMaxExample example);

    int deleteByExample(StressMaxExample example);

    int insert(StressMax record);

    int insertSelective(StressMax record);

    List<StressMax> selectByExample(StressMaxExample example);

    int updateByExampleSelective(@Param("record") StressMax record, @Param("example") StressMaxExample example);

    int updateByExample(@Param("record") StressMax record, @Param("example") StressMaxExample example);

    int getMaxId();

    List<StressMax> getAll(BigDecimal id, int start, int end);
}