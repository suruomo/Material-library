package com.suruomo.material.dao;

import com.suruomo.material.pojo.MetalInput;
import com.suruomo.material.pojo.MetalOut;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface MetalInputMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(MetalInput record);

    int insertSelective(MetalInput record);

    MetalInput selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(MetalInput record);

    int updateByPrimaryKey(MetalInput record);

    List<MetalOut> getAll(int start, int end);

    int getCount();

    BigDecimal getMaxId();
}