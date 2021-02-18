package com.suruomo.material.dao;

import com.suruomo.material.pojo.ModelTask;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ModelTaskMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(ModelTask record);

    int insertSelective(ModelTask record);

    ModelTask selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(ModelTask record);

    int updateByPrimaryKey(ModelTask record);

    List<ModelTask> getAll(int start, int end);

    BigDecimal getMaxId();
}