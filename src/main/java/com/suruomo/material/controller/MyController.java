package com.suruomo.material.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.suruomo.material.dao.*;
import com.suruomo.material.pojo.*;
import com.suruomo.material.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author: suruomo
 * @date: 2021/2/1 16:42
 * @description:
 */
@Controller
public class MyController {

    @Resource
    private ModelTaskMapper modelTaskMapper;

    @Resource
    private AnalysisTaskMapper analysisTaskMapper;

    @Resource
    private Result result;

    @Resource
    private ConstrainForceResultMapper constrainForceResultMapper;

    @Resource
    private DistanceResultMapper distanceResultMapper;

    @Resource
    private GridStrainResultMapper gridStrainResultMapper;

    @Resource
    private GridStressResultMapper gridStressResultMapper;

    @Resource
    private ModeFrequencyResultMapper modeFrequencyResultMapper;

    @Resource
    private ModeShapeResultMapper modeShapeResultMapper;

    /**
     * 我的数据主页面
     *
     * @return
     */
    @GetMapping(value = {"/my"})
    public String myData() {
        return "my/index";
    }

    /**
     * 跳转创建新模型任务页面
     *
     * @return
     */
    @GetMapping(value = {"/task/model"})
    public String myTaskModel() {
        return "my/add_task_model";
    }

    /**
     * 返回模型任务数据
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/task/models", params = {"page", "limit"})
    public Map<String, Object> modelList(int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        List<ModelTask> lists = modelTaskMapper.getAll(start, end);
        return result.getResult(lists);
    }

    /**
     * 根据id跳转模型任务详情页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/task/model/{id}")
    public String cardInfo(@PathVariable String id, Model model) {
        ModelTask modelTask = modelTaskMapper.selectByPrimaryKey(new BigDecimal(id));
        model.addAttribute("model", modelTask);
        return "my/task_model_info";
    }

    /**
     * 返回分析任务数据
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/task/analysis", params = {"page", "limit"})
    public Map<String, Object> analysisList(int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        List<AnalysisTask> lists = analysisTaskMapper.getAll(start, end);
        return result.getResult(lists);
    }

    /**
     * 跳转创建新分析任务表单页面
     */
    @ResponseBody
    @PostMapping(value = "/task/analysis", params = {"modelId"})
    public String analysisForm(String modelId) {
        return "1";
    }

    /**
     * 跳转创建新分析任务页面
     *
     * @return
     */
    @GetMapping(value = {"/task/analysis"})
    public String myTaskAnalysis() {
        return "my/add_task_analysis";
    }

    /**
     * 根据分析任务id和分析类型跳转分析结果页面
     *
     * @param id
     * @param type
     * @param model
     * @return
     */
    @GetMapping("/analysis/result/{id}/{type}")
    public String analysisResultInfo(@PathVariable String id, @PathVariable String type, Model model) {
        AnalysisTask analysisTask=analysisTaskMapper.selectByPrimaryKey(new BigDecimal(id));
        model.addAttribute("analysisTask",analysisTask);
        switch (type){
            case "静力分析":
                return "my/static_results";
            case "正向模态":
                return "my/mode_results";
//            case "气动颤振":
//                return "my/flutter_results";
//                break;
            default:
                return "出错啦";
        }
    }

    /**
     * 返回静力分析的位移结果数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/static/results/distance", params = {"page", "limit"})
    public Map<String, Object> distanceList(int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        List<DistanceResult> lists = distanceResultMapper.getAll(start, end);
        return result.getResult(lists);
    }

    /**
     * 返回静力分析的约束反力数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/static/results/constrainForce", params = {"page", "limit"})
    public Map<String, Object> constrainForceList(int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        List<ConstrainForceResult> lists = constrainForceResultMapper.getAll(start, end);
        return result.getResult(lists);
    }

    /**
     * 返回静力分析的节点应力表
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/static/results/gridStress", params = {"page", "limit"})
    public Map<String, Object> gridStressList(int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        List<GridStressResult> lists = gridStressResultMapper.getAll(start, end);
        return result.getResult(lists);
    }
    /**
     * 返回静力分析的节点应变表
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/static/results/gridStrain", params = {"page", "limit"})
    public Map<String, Object> gridStrainList(int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        List<GridStrainResult> lists = gridStrainResultMapper.getAll(start, end);
        return result.getResult(lists);
    }
    /**
     * 返回正向模态的模态频率表
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/mode/results/frequency", params = {"page", "limit"})
    public Map<String, Object> modeFrequencyList(int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        List<ModeFrequencyResult> lists = modeFrequencyResultMapper.getAll(start, end);
        return result.getResult(lists);
    }

    /**
     * 返回正向模态的模态振型表
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/mode/results/shape", params = {"page", "limit"})
    public Map<String, Object> modeShapeList(int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        List<ModeShapeResult> lists = modeShapeResultMapper.getAll(start, end);
        return result.getResult(lists);
    }
}
