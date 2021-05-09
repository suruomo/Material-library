package com.suruomo.material.dao;

import com.suruomo.material.pojo.MaxSpcforceResult;
import com.suruomo.material.pojo.MaxSpcforceResultExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaxSpcforceResultMapper {
    int countByExample(MaxSpcforceResultExample example);

    int deleteByExample(MaxSpcforceResultExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(MaxSpcforceResult record);

    int insertSelective(MaxSpcforceResult record);

    List<MaxSpcforceResult> selectByExample(MaxSpcforceResultExample example);

    MaxSpcforceResult selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") MaxSpcforceResult record, @Param("example") MaxSpcforceResultExample example);

    int updateByExample(@Param("record") MaxSpcforceResult record, @Param("example") MaxSpcforceResultExample example);

    int updateByPrimaryKeySelective(MaxSpcforceResult record);

    int updateByPrimaryKey(MaxSpcforceResult record);
}