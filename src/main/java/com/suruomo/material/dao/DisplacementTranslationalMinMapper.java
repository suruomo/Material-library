package com.suruomo.material.dao;

import com.suruomo.material.pojo.DisplacementTranslationalMin;
import com.suruomo.material.pojo.DisplacementTranslationalMinExample;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DisplacementTranslationalMinMapper {
    int countByExample(DisplacementTranslationalMinExample example);

    int deleteByExample(DisplacementTranslationalMinExample example);

    int insert(DisplacementTranslationalMin record);

    int insertSelective(DisplacementTranslationalMin record);

    List<DisplacementTranslationalMin> selectByExample(DisplacementTranslationalMinExample example);

    int updateByExampleSelective(@Param("record") DisplacementTranslationalMin record, @Param("example") DisplacementTranslationalMinExample example);

    int updateByExample(@Param("record") DisplacementTranslationalMin record, @Param("example") DisplacementTranslationalMinExample example);

    int getMaxId();

    List<DisplacementTranslationalMin> getAll(BigDecimal id, int start, int end);
}