package com.suruomo.material.dao;

import com.suruomo.material.pojo.ModeFactors;
import com.suruomo.material.pojo.ModeFactorsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ModeFactorsMapper {
    int countByExample(ModeFactorsExample example);

    int deleteByExample(ModeFactorsExample example);

    int insert(ModeFactors record);

    int insertSelective(ModeFactors record);

    List<ModeFactors> selectByExample(ModeFactorsExample example);

    int updateByExampleSelective(@Param("record") ModeFactors record, @Param("example") ModeFactorsExample example);

    int updateByExample(@Param("record") ModeFactors record, @Param("example") ModeFactorsExample example);
}