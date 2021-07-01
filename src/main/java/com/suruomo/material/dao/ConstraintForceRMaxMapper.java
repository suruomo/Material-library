package com.suruomo.material.dao;

import com.suruomo.material.pojo.ConstraintForceRMax;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConstraintForceRMaxMapper {
    int insert(ConstraintForceRMax record);

    int insertSelective(ConstraintForceRMax record);
}