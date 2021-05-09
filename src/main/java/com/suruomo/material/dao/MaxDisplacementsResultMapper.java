package com.suruomo.material.dao;

import com.suruomo.material.pojo.MaxDisplacementsResult;
import com.suruomo.material.pojo.MaxDisplacementsResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaxDisplacementsResultMapper {
    int countByExample(MaxDisplacementsResultExample example);

    int deleteByExample(MaxDisplacementsResultExample example);

    int insert(MaxDisplacementsResult record);

    int insertSelective(MaxDisplacementsResult record);

    List<MaxDisplacementsResult> selectByExample(MaxDisplacementsResultExample example);

    int updateByExampleSelective(@Param("record") MaxDisplacementsResult record, @Param("example") MaxDisplacementsResultExample example);

    int updateByExample(@Param("record") MaxDisplacementsResult record, @Param("example") MaxDisplacementsResultExample example);
}