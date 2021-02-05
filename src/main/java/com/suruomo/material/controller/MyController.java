package com.suruomo.material.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suruomo.material.dao.AnalysisTaskMapper;
import com.suruomo.material.dao.ModelTaskMapper;
import com.suruomo.material.pojo.AnalysisTask;
import com.suruomo.material.pojo.ModelTask;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
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

    @GetMapping(value = {"/my"})
    public String myData() {
        return "my/index";
    }

    /**
     * 跳转创建新模型任务页面
     * @return
     */
    @GetMapping(value = {"/task/model"})
    public String myTaskModel() {
        return "my/add_task_model";
    }
    /**
     * 返回模型任务数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/task/models",params = {"page","limit"})
    public Map<String, Object> modelList(int page, int limit) throws  JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<ModelTask> models = modelTaskMapper.getAll(start, end);
        int count = models.size();
        HashMap<String, Object> map = new HashMap();
        //返回Json
        ObjectMapper mapper = new ObjectMapper();
        //json内对象不为空
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String data = mapper.writeValueAsString(models);
        JSONArray json = JSONArray.fromObject(data);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", json);
        map.put("count", count);
        return map;
    }

    /**
     * 根据id跳转模型任务详情页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/task/model/{id}")
    public String cardInfo(@PathVariable String id, Model model) {
        ModelTask modelTask=modelTaskMapper.selectByPrimaryKey(new BigDecimal(id));
        model.addAttribute("model",modelTask);
        return "my/task_model_info";
    }
    /**
     * 返回分析任务数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/task/analysis",params = {"page","limit"})
    public Map<String, Object> analysisList(int page, int limit) throws  JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<AnalysisTask> tasks = analysisTaskMapper.getAll(start, end);
        int count = tasks.size();
        HashMap<String, Object> map = new HashMap();
        //返回Json
        ObjectMapper mapper = new ObjectMapper();
        //json内对象不为空
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String data = mapper.writeValueAsString(tasks);
        JSONArray json = JSONArray.fromObject(data);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", json);
        map.put("count", count);
        return map;
    }
}
