package com.suruomo.material.utils;

import com.suruomo.material.dao.ConstrainForceResultMapper;
import com.suruomo.material.dao.DistanceResultMapper;
import com.suruomo.material.dao.GridStrainResultMapper;
import com.suruomo.material.dao.GridStressResultMapper;
import com.suruomo.material.pojo.DistanceResult;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2021/2/8 14:52
 * @description: 获取静力分析结果
 */
public class StaticAnalysis {
    @Resource
    private ConstrainForceResultMapper constrainForceResultMapper;

    @Resource
    private DistanceResultMapper distanceResultMapper;

    @Resource
    private GridStrainResultMapper gridStrainResultMapper;

    @Resource
    private GridStressResultMapper gridStressResultMapper;

    public void getStaticDataLists(String id, Model model){
//        List<DistanceResult> distanceResultList=distanceResultMapper.getAll()
    }
}
