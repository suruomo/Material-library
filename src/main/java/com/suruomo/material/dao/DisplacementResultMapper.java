package com.suruomo.material.dao;

import com.suruomo.material.pojo.DisplacementResult;
import com.suruomo.material.pojo.DisplacementResultExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DisplacementResultMapper {
    int countByExample(DisplacementResultExample example);

    int deleteByExample(DisplacementResultExample example);

    int insert(DisplacementResult record);

    int insertSelective(DisplacementResult record);

    List<DisplacementResult> selectByExample(DisplacementResultExample example);

    int updateByExampleSelective(@Param("record") DisplacementResult record, @Param("example") DisplacementResultExample example);

    int updateByExample(@Param("record") DisplacementResult record, @Param("example") DisplacementResultExample example);

    List<DisplacementResult> getAll(BigDecimal id, int start, int end);
}