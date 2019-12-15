package com.suruomo.material.dao;

import com.suruomo.material.pojo.MetalOut;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 苏若墨
 */
@Mapper
public interface MetalOutMapper {
    int deleteByPrimaryKey(String name);

    int insert(MetalOut record);

    int insertSelective(MetalOut record);

    MetalOut selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(MetalOut record);

    int updateByPrimaryKey(MetalOut record);

    List<MetalOut> getAll(int start, int end, String queryType);

    int getCount(String queryType);
}