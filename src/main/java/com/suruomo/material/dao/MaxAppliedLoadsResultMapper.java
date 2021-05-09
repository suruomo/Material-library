package com.suruomo.material.dao;

import com.suruomo.material.pojo.MaxAppliedLoadsResult;
import com.suruomo.material.pojo.MaxAppliedLoadsResultExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaxAppliedLoadsResultMapper {
    int countByExample(MaxAppliedLoadsResultExample example);

    int deleteByExample(MaxAppliedLoadsResultExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(MaxAppliedLoadsResult record);

    int insertSelective(MaxAppliedLoadsResult record);

    List<MaxAppliedLoadsResult> selectByExample(MaxAppliedLoadsResultExample example);

    MaxAppliedLoadsResult selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") MaxAppliedLoadsResult record, @Param("example") MaxAppliedLoadsResultExample example);

    int updateByExample(@Param("record") MaxAppliedLoadsResult record, @Param("example") MaxAppliedLoadsResultExample example);

    int updateByPrimaryKeySelective(MaxAppliedLoadsResult record);

    int updateByPrimaryKey(MaxAppliedLoadsResult record);
}