package com.suruomo.material.dao;

import com.suruomo.material.pojo.Layup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LayupMapper {
    int deleteByPrimaryKey(String name);

    int insert(Layup record);

    int insertSelective(Layup record);

    Layup selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Layup record);

    int updateByPrimaryKey(Layup record);

    List<Layup> getAll(int start, int end);

    int getCount();

    List<Layup> getList();

    List<Layup> getByName(int start, int end, String name);
}