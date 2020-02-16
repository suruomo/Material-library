package com.suruomo.material.dao;

import com.suruomo.material.pojo.CompositeInput;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface CompositeInputMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(CompositeInput record);

    int insertSelective(CompositeInput record);

    CompositeInput selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(CompositeInput record);

    int updateByPrimaryKey(CompositeInput record);

    List<CompositeInput> getAll(int start, int end);

    int getCount();

    Integer getMaxId();

    List<CompositeInput> getList();
}