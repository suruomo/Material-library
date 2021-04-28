package com.suruomo.material.dao;

import com.suruomo.material.pojo.ModeShapeResult;
import java.math.BigDecimal;
import java.util.List;

public interface ModeShapeResultMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(ModeShapeResult record);

    int insertSelective(ModeShapeResult record);

    ModeShapeResult selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(ModeShapeResult record);

    int updateByPrimaryKey(ModeShapeResult record);

    List<ModeShapeResult> getAll(BigDecimal id, int start, int end);
}