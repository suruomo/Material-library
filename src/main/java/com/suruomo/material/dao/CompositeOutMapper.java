package com.suruomo.material.dao;

import com.suruomo.material.pojo.CompositeOut;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 苏若墨
 */
@Mapper
public interface CompositeOutMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(CompositeOut record);

    int insertSelective(CompositeOut record);

    CompositeOut selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(CompositeOut record);

    int updateByPrimaryKey(CompositeOut record);

    List<CompositeOut> getAll(int start, int end);

    int getCount();
}