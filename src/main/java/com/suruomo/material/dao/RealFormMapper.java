package com.suruomo.material.dao;

import com.suruomo.material.pojo.RealForm;
import java.math.BigDecimal;
import java.util.List;

public interface RealFormMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(RealForm record);

    int insertSelective(RealForm record);

    RealForm selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(RealForm record);

    int updateByPrimaryKey(RealForm record);

    List<RealForm> getAll(String realId, int start, int end);
}