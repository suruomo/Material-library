package com.suruomo.material.dao;

import com.suruomo.material.pojo.Log;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface LogMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);

    List<Log> getAll(int start, int end);

    int getAllCount();

    int getMaxId();

    List<Log> getList(int start, int end, String startTime, String endTime);
}