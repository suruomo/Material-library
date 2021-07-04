package com.suruomo.material.dao;

import com.suruomo.material.pojo.StrainMin;
import com.suruomo.material.pojo.StrainMinExample;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StrainMinMapper {
    int countByExample(StrainMinExample example);

    int deleteByExample(StrainMinExample example);

    int insert(StrainMin record);

    int insertSelective(StrainMin record);

    List<StrainMin> selectByExample(StrainMinExample example);

    int updateByExampleSelective(@Param("record") StrainMin record, @Param("example") StrainMinExample example);

    int updateByExample(@Param("record") StrainMin record, @Param("example") StrainMinExample example);

    int getMaxId();

    List<StrainMin> getAll(BigDecimal id, int start, int end);
}