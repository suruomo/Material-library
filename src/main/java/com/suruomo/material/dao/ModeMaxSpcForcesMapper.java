package com.suruomo.material.dao;

import com.suruomo.material.pojo.ModeMaxSpcForces;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ModeMaxSpcForcesMapper {
    int insert(ModeMaxSpcForces record);

    int insertSelective(ModeMaxSpcForces record);

    int getMaxId();

    List<ModeMaxSpcForces> getAll(BigDecimal id, int start, int end);
}