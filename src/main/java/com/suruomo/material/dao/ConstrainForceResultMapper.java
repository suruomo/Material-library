package com.suruomo.material.dao;

import com.suruomo.material.pojo.ConstrainForceResult;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ConstrainForceResultMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(ConstrainForceResult record);

    int insertSelective(ConstrainForceResult record);

    ConstrainForceResult selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(ConstrainForceResult record);

    int updateByPrimaryKey(ConstrainForceResult record);

    List<ConstrainForceResult> getAll(BigDecimal id, int start, int end);
}