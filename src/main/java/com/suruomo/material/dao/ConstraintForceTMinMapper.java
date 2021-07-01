package com.suruomo.material.dao;

import com.suruomo.material.pojo.ConstraintForceTMin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConstraintForceTMinMapper {
    int insert(ConstraintForceTMin record);

    int insertSelective(ConstraintForceTMin record);
}