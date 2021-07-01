package com.suruomo.material.dao;

import com.suruomo.material.pojo.ConstraintForceRMin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConstraintForceRMinMapper {
    int insert(ConstraintForceRMin record);

    int insertSelective(ConstraintForceRMin record);
}