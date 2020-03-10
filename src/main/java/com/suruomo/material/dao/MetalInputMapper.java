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

    List<MetalInput> getAll(int start, int end);

    int getCount();

    BigDecimal getMaxId();

    List<MetalInput> getList();

    List<String> getFamily(String typeName);

    List<String> getTemper(String family);

    List<MetalInput> getAllByType(int start, int end, String typeName);

    List<MetalInput> getAllDataByNT(int start, int end, String typeName, String family);

    List<MetalInput> getAllDataByCondition(int start, int end, String typeName, String family, String temper);
}