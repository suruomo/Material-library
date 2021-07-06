package com.suruomo.material.dao;

import com.suruomo.material.pojo.LoadBCS;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
@Mapper
public interface LoadBCSMapper {
    int insert(LoadBCS record);

    int insertSelective(LoadBCS record);

    List<LoadBCS> getAll(BigDecimal id, int start, int end);

    int getMaxId();

    void deleteByAnalysisId(BigDecimal analysisId);
}