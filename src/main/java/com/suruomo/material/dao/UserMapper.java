package com.suruomo.material.dao;

import com.suruomo.material.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findByToken(String token);

    long findMaxUserId();

    List<User> getAll(int start, int end);

    int getCount();
}