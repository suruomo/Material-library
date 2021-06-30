package com.suruomo.material.dao;

import com.suruomo.material.pojo.DisplacementRotationalMin;
import com.suruomo.material.pojo.DisplacementRotationalMinExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DisplacementRotationalMinMapper {
    int countByExample(DisplacementRotationalMinExample example);

    int deleteByExample(DisplacementRotationalMinExample example);

    int insert(DisplacementRotationalMin record);

    int insertSelective(DisplacementRotationalMin record);

    List<DisplacementRotationalMin> selectByExample(DisplacementRotationalMinExample example);

    int updateByExampleSelective(@Param("record") DisplacementRotationalMin record, @Param("example") DisplacementRotationalMinExample example);

    int updateByExample(@Param("record") DisplacementRotationalMin record, @Param("example") DisplacementRotationalMinExample example);

    int getMaxId();
}