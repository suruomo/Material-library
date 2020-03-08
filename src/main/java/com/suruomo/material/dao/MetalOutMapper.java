package com.suruomo.material.dao;

import com.suruomo.material.pojo.MetalOut;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 苏若墨
 */
@Mapper
public interface MetalOutMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(MetalOut record);

    int insertSelective(MetalOut record);

    MetalOut selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(MetalOut record);

    int updateByPrimaryKey(MetalOut record);

    List<MetalOut> getAll(int start, int end, String queryType);

    int getCount(String queryType);

    List<MetalOut> getAllData(int start, int end);

    int getAllCount();

    Integer getMaxId();

    List<MetalOut> getList();

    List<String> getFamily(String typeName);

    List<String> getTemper(String family);

    List<MetalOut> getAllDataByCondition(int start, int end, String typeName, String family, String temper);

    List<MetalOut> getAllDataByNT(int start, int end, String typeName, String family);
}