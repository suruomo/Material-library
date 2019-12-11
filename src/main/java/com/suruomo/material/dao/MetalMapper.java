package com.suruomo.material.dao;

import com.suruomo.material.pojo.Metal;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
@Mapper
public interface MetalMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Metal record);

    int insertSelective(Metal record);

    Metal selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Metal record);

    int updateByPrimaryKey(Metal record);

    List<Metal> getAll(int start, int end, String type);

    int getCount(String queryType);
}