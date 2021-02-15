package com.suruomo.material.dao;

import com.suruomo.material.pojo.FlutterSpeedCrossingsResult;
import com.suruomo.material.pojo.ModeShapeResult;

import java.math.BigDecimal;
import java.util.List;

public interface FlutterSpeedCrossingsResultMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(FlutterSpeedCrossingsResult record);

    int insertSelective(FlutterSpeedCrossingsResult record);

    FlutterSpeedCrossingsResult selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(FlutterSpeedCrossingsResult record);

    int updateByPrimaryKey(FlutterSpeedCrossingsResult record);

    List<FlutterSpeedCrossingsResult> getAll(int start, int end);
}