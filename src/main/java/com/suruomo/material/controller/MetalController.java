package com.suruomo.material.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suruomo.material.dao.MetalInputMapper;
import com.suruomo.material.dao.MetalOutMapper;
import com.suruomo.material.dto.Mat1;
import com.suruomo.material.pojo.MetalInput;
import com.suruomo.material.pojo.MetalOut;
import com.suruomo.material.utils.ExportMat1;
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
public class MetalController {
    @Resource
    MetalOutMapper metalOutMapper;
    @Resource
    MetalInputMapper metalInputMapper;
    /**
     * 跳转原始数据列表页面
     * @return
     */
    @GetMapping("/metal/rawdata")
    public String rawDatas() {
        return "metal/all";
    }
    /**
     * 跳转所有铝数据列表页面
     * @return
     */
    @GetMapping("/metal/aluminum")
    public String aluminumList(Model model) {
        model.addAttribute("type","aluminum");
        return "metal/list";
    }
    /**
     * 跳转所有钢数据列表页面
     * @return
     */
    @GetMapping("/metal/steel")
    public String steelList(Model model) {
        model.addAttribute("type","steel");
        return "metal/list";
    }
    /**
     * 跳转所有钛数据列表页面
     * @return
     */
    @GetMapping("/metal/titanium")
    public String titaniumList(Model model) {
        model.addAttribute("type","titanium");
        return "metal/list";
    }
    /**
     * 返回查询全部金属数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/metals")
    public Map<String, Object> mentals(@RequestParam("page") int page, @RequestParam("limit") int limit) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<MetalOut> users = metalInputMapper.getAll(start, end);
        int count = metalInputMapper.getCount();
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
     * 返回查询导出材料卡金属数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/metals/{type}")
    public Map<String, Object> list(@RequestParam("page") int page, @RequestParam("limit") int limit,@PathVariable("type") String type) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        String queryType = "";
        if ("aluminum".equals(type)) {
            queryType = "EO_Material_Aluminium";
        } else {
            if ("steel".equals(type)) {
                queryType = "EO_Material_Steel";
            } else  {
                queryType = "EO_Material_Titanium";
            }
        }
        List<MetalOut> users = metalOutMapper.getAll(start, end,queryType);
        int count = metalOutMapper.getCount(queryType);
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
     * 跳转至金属信息页面
     * @return
     */

    @GetMapping("/metal/{id}")
    public String info(@PathVariable String id, Model model) {
        MetalInput metalInput=metalInputMapper.selectByPrimaryKey(new BigDecimal(id));
        model.addAttribute("metal",metalInput);
        return "metal/info";
    }
    /**
     * 跳转至导出MAT1页面
     * @return
     */

    @GetMapping("/metal/export/{id}")
    public String mat(@PathVariable String id, Model model) {
        MetalOut metalOut=metalOutMapper.selectByPrimaryKey(new BigDecimal(id));
        model.addAttribute("metal",metalOut);
        return "metal/mat1";
    }

    /**
     * 导出MAT1卡片.bdf文件下载
     */
    @PostMapping("/export/mat1")
    public void exportMat1(Mat1 mat1, HttpServletResponse response) throws IOException {
        ExportMat1 exportMat1=new ExportMat1();
        //获取输入流，
        InputStream bis = new BufferedInputStream(new FileInputStream(exportMat1.export(mat1)));
        //假如以中文名下载的话，设置下载文件名称
        String filename = mat1.getID()+"导出MAT1卡片.bdf";
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
