package com.suruomo.material.dao;

import com.suruomo.material.pojo.DisplacementRotationalMax;
import com.suruomo.material.pojo.DisplacementRotationalMaxExample;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DisplacementRotationalMaxMapper {
    int countByExample(DisplacementRotationalMaxExample example);

    int deleteByExample(DisplacementRotationalMaxExample example);

    int insert(DisplacementRotationalMax record);

    int insertSelective(DisplacementRotationalMax record);

    List<DisplacementRotationalMax> selectByExample(DisplacementRotationalMaxExample example);

    int updateByExampleSelective(@Param("record") DisplacementRotationalMax record, @Param("example") DisplacementRotationalMaxExample example);

    int updateByExample(@Param("record") DisplacementRotationalMax record, @Param("example") DisplacementRotationalMaxExample example);

    int getMaxId();

    List<DisplacementRotationalMax> getAll(BigDecimal id, int start, int end);
}