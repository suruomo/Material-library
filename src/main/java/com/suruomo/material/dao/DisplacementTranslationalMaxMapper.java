package com.suruomo.material.dao;

import com.suruomo.material.pojo.DisplacementTranslationalMax;
import com.suruomo.material.pojo.DisplacementTranslationalMaxExample;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DisplacementTranslationalMaxMapper {
    int countByExample(DisplacementTranslationalMaxExample example);

    int deleteByExample(DisplacementTranslationalMaxExample example);

    int insert(DisplacementTranslationalMax record);

    int insertSelective(DisplacementTranslationalMax record);

    List<DisplacementTranslationalMax> selectByExample(DisplacementTranslationalMaxExample example);

    int updateByExampleSelective(@Param("record") DisplacementTranslationalMax record, @Param("example") DisplacementTranslationalMaxExample example);

    int updateByExample(@Param("record") DisplacementTranslationalMax record, @Param("example") DisplacementTranslationalMaxExample example);

    int getMaxId();

    List<DisplacementTranslationalMax> getAll(BigDecimal id, int start, int end);

    void deleteByAnalysisId(BigDecimal analysisId);
}