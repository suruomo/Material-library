package com.suruomo.material.dao;

import com.suruomo.material.pojo.DisplacementResult;

import java.math.BigDecimal;
import java.util.List;

public interface DisplacementResultMapper {
    int insert(DisplacementResult record);

    int insertSelective(DisplacementResult record);

    List<DisplacementResult> getAll(BigDecimal id, int start, int end);
}