package com.suruomo.material.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: suruomo
 * @date: 2021/2/5 18:24
 * @description:
 */
@Component
public class Result {

    public Map<String, Object> successResult(List<? extends Object> list) throws JsonProcessingException {
        HashMap<String,Object> map=new HashMap<>();
        // 数据量
        int count = list.size();
        //返回Json
        ObjectMapper mapper = new ObjectMapper();
        //json内对象不为空
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String data = mapper.writeValueAsString(list);
        JSONArray json = JSONArray.fromObject(data);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", json);
        map.put("count", count);
        return map;
    }
    public Map<String, Object> errorsResult() throws JsonProcessingException {
        HashMap<String,Object> map=new HashMap<>();
        //返回Json
        ObjectMapper mapper = new ObjectMapper();
        //json内对象不为空
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String data = mapper.writeValueAsString("no data");
        JSONArray json = JSONArray.fromObject(data);
        map.put("code", 1);
        map.put("msg", "出错啦");
        map.put("data", json);
        map.put("count", 0);
        return map;
    }
}
