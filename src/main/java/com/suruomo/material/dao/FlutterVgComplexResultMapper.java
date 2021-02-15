package com.suruomo.material.dao;

import com.suruomo.material.pojo.FlutterVgComplexResult;
import java.math.BigDecimal;
import java.util.List;

public interface FlutterVgComplexResultMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(FlutterVgComplexResult record);

    int insertSelective(FlutterVgComplexResult record);

    FlutterVgComplexResult selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(FlutterVgComplexResult record);

    int updateByPrimaryKey(FlutterVgComplexResult record);

    List<FlutterVgComplexResult> getAll(int start, int end);
}