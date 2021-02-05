package com.suruomo.material.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suruomo.material.dao.LogMapper;
import com.suruomo.material.pojo.Log;
import com.suruomo.material.service.LogService;
import com.suruomo.material.utils.Result;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 苏若墨
 */
@Controller
public class LogController {
    @Resource
    private LogMapper logMapper;
    @Resource
    private LogService logService;
    @Resource
    private Result result;
    /**
     * 跳转日志列表界面
     * @return
     */
    @GetMapping("/admin/log")
    public String loglList() {
        return "admin/log/list";
    }

    /**
     * 返回日志数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/logs",params = {"page","limit"})
    public Map<String, Object> cards( int page, int limit) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<Log> lists = logService.getAll(start, end);
        return result.getResult(lists);
    }

    /**
     * 按照日期范围筛选日志
     * @param page
     * @param limit
     * @param range
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping (value = "/logs", params = {"page","limit","range"})
    public Map<String,Object> showLogs(int page, int limit,String  range)  throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        HashMap<String, Object> map = new HashMap();
        List<Log> lists=new ArrayList<>();
        JSONArray json=new JSONArray();
        //数据量
        int count=0;
        try{
            lists = logService.getList(start, end,range);
             count = logMapper.getAllCount();
            //返回Json
            ObjectMapper mapper = new ObjectMapper();
            //json内对象不为空
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String data = mapper.writeValueAsString(lists);
             json = JSONArray.fromObject(data);
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", json);
            map.put("count", count);
        }catch (Exception e){
            map.put("code", 1);
            map.put("msg", "无该月份数据");
            map.put("data", " ");
            map.put("count", 0);
        }
        return map;
    }

}
