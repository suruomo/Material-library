package com.suruomo.material.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suruomo.material.dao.CompositeInputMapper;
import com.suruomo.material.dao.CompositeOutMapper;
import com.suruomo.material.dto.Mat8;
import com.suruomo.material.pojo.CompositeInput;
import com.suruomo.material.pojo.CompositeOut;
import com.suruomo.material.utils.ExportMat8;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 苏若墨
 */
@Controller
public class CompositeController {
    @Resource
    CompositeOutMapper compositeOutMapper;
    @Resource
    CompositeInputMapper compositeInputMapper;
    /**
     * 跳转原始数据列表页面
     * @return
     */
    @GetMapping("/composite/rawdata")
    public String rawDatas() {
        return "composite/all";
    }
    /**
     * 跳转所有复合数据列表页面
     * @return
     */
    @GetMapping("/composite")
    public String aluminumList() {
        return "composite/list";
    }
    /**
     * 返回查询金全部复合数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/compositerawdatas")
    public Map<String, Object> composites(@RequestParam("page") int page, @RequestParam("limit") int limit) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<CompositeInput> users = compositeInputMapper.getAll(start, end);
        int count = compositeInputMapper.getCount();
        HashMap<String, Object> map = new HashMap();
        //返回Json
        ObjectMapper mapper = new ObjectMapper();
        //json内对象不为空
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String data = mapper.writeValueAsString(users);
        JSONArray json = JSONArray.fromObject(data);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", json);
        map.put("count", count);
        return map;
    }

    /**
     * 返回查询导出材料卡复合数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/composites")
    public Map<String, Object> list(@RequestParam("page") int page, @RequestParam("limit") int limit) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<CompositeOut> users = compositeOutMapper.getAll(start, end);
        int count = compositeOutMapper.getCount();
        HashMap<String, Object> map = new HashMap();
        //返回Json
        ObjectMapper mapper = new ObjectMapper();
        //json内对象不为空
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String data = mapper.writeValueAsString(users);
        JSONArray json = JSONArray.fromObject(data);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", json);
        map.put("count", count);
        return map;
    }

    /**
     * 跳转至导出MAT8页面
     * @return
     */

    @GetMapping("/composite/export/{id}")
    public String mat(@PathVariable String id, Model model) {
        CompositeOut compositeOut=compositeOutMapper.selectByPrimaryKey(new BigDecimal(id));
        model.addAttribute("composite",compositeOut);
        return "composite/mat8";
    }

    /**
     * 导出MAT8卡片.bdf文件下载
     */
    @PostMapping("/export/mat8")
    public void exportMat1(Mat8 mat8, HttpServletResponse response) throws IOException {
        ExportMat8 exportMat8=new ExportMat8();
        System.out.println(mat8.toString());
        //获取输入流，
        InputStream bis = new BufferedInputStream(new FileInputStream(exportMat8.export(mat8)));
        //假如以中文名下载的话，设置下载文件名称
        String filename = mat8.getID()+"导出MAT8卡片.bdf";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename, "UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();
    }
}
