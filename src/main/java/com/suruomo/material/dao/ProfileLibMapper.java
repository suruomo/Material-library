package com.suruomo.material.dao;

import com.suruomo.material.pojo.ProfileLib;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfileLibMapper {
    int insert(ProfileLib record);

    int insertSelective(ProfileLib record);

    List<ProfileLib> getAll(int start, int end);
}