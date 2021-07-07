package com.suruomo.material.dao;

import com.suruomo.material.pojo.ModeMaxDisplacements;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ModeMaxDisplacementsMapper {
    int insert(ModeMaxDisplacements record);

    int insertSelective(ModeMaxDisplacements record);

    int getMaxId();

    List<ModeMaxDisplacements> getAll(BigDecimal id, int start, int end);

    void deleteByPrimaryKey(BigDecimal analysisId);
}