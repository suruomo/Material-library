package com.suruomo.material.dao;

import com.suruomo.material.pojo.ComplexForm;
import java.math.BigDecimal;
import java.util.List;

public interface ComplexFormMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(ComplexForm record);

    int insertSelective(ComplexForm record);

    ComplexForm selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(ComplexForm record);

    int updateByPrimaryKey(ComplexForm record);

    List<ComplexForm> getAll(String complexId, int start, int end);
}