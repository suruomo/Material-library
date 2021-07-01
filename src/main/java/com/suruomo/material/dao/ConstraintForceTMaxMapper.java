package com.suruomo.material.dao;

import com.suruomo.material.pojo.ConstraintForceTMax;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConstraintForceTMaxMapper {
    int insert(ConstraintForceTMax record);

    int insertSelective(ConstraintForceTMax record);
}