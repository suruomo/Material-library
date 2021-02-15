package com.suruomo.material.dao;

import com.suruomo.material.pojo.FlutterVgReALResult;
import java.math.BigDecimal;
import java.util.List;

public interface FlutterVgReALResultMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(FlutterVgReALResult record);

    int insertSelective(FlutterVgReALResult record);

    FlutterVgReALResult selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(FlutterVgReALResult record);

    int updateByPrimaryKey(FlutterVgReALResult record);

    List<FlutterVgReALResult> getAll(int start, int end);
}