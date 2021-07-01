package com.suruomo.material.dao;

import com.suruomo.material.pojo.Material;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
@Mapper
public interface MaterialMapper {
    int insert(Material record);

    int insertSelective(Material record);

    List<Material> getAll(BigDecimal id, int start, int end);
}