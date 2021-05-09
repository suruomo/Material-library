package com.suruomo.material.dao;

import com.suruomo.material.pojo.OloadResult;
import com.suruomo.material.pojo.OloadResultExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OloadResultMapper {
    int countByExample(OloadResultExample example);

    int deleteByExample(OloadResultExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(OloadResult record);

    int insertSelective(OloadResult record);

    List<OloadResult> selectByExample(OloadResultExample example);

    OloadResult selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") OloadResult record, @Param("example") OloadResultExample example);

    int updateByExample(@Param("record") OloadResult record, @Param("example") OloadResultExample example);

    int updateByPrimaryKeySelective(OloadResult record);

    int updateByPrimaryKey(OloadResult record);
}