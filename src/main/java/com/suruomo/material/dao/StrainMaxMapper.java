package com.suruomo.material.dao;

import com.suruomo.material.pojo.StrainMax;
import com.suruomo.material.pojo.StrainMaxExample;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StrainMaxMapper {
    int countByExample(StrainMaxExample example);

    int deleteByExample(StrainMaxExample example);

    int insert(StrainMax record);

    int insertSelective(StrainMax record);

    List<StrainMax> selectByExample(StrainMaxExample example);

    int updateByExampleSelective(@Param("record") StrainMax record, @Param("example") StrainMaxExample example);

    int updateByExample(@Param("record") StrainMax record, @Param("example") StrainMaxExample example);

    int getMaxId();

    List<StrainMax> getAll(BigDecimal id, int start, int end);
}