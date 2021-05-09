package com.suruomo.material.dao;

import com.suruomo.material.pojo.SpcforceResult;
import com.suruomo.material.pojo.SpcforceResultExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpcforceResultMapper {
    int countByExample(SpcforceResultExample example);

    int deleteByExample(SpcforceResultExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(SpcforceResult record);

    int insertSelective(SpcforceResult record);

    List<SpcforceResult> selectByExample(SpcforceResultExample example);

    SpcforceResult selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") SpcforceResult record, @Param("example") SpcforceResultExample example);

    int updateByExample(@Param("record") SpcforceResult record, @Param("example") SpcforceResultExample example);

    int updateByPrimaryKeySelective(SpcforceResult record);

    int updateByPrimaryKey(SpcforceResult record);
}