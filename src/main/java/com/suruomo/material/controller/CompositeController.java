package com.suruomo.material.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suruomo.material.dao.CompositeInputMapper;
import com.suruomo.material.dao.CompositeOutMapper;
import com.suruomo.material.dto.Mat8;
import com.suruomo.material.pojo.CompositeInput;
import com.suruomo.material.pojo.CompositeOut;
import com.suruomo.material.service.CompositeService;
import com.suruomo.material.utils.ExcelUtil;
import com.suruomo.material.utils.ExportMat8;
import net.sf.json.JSONArray;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @Resource
    CompositeService compositeService;
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
     * 删除原始复合
     * @param id
     * @param model
     * @return
     */
    @DeleteMapping ("/composite/original/{id}")
    @ResponseBody
    public String deleteOriginal(@PathVariable String id, Model model) {
        compositeInputMapper.deleteByPrimaryKey(new BigDecimal(id));
        return "success";
    }
    /**
     * 跳转管理员原始复合
     * @return
     */
    @GetMapping("/admin/composite/original")
    public String originalList() {
        return "admin/composite/originalList";
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

    /**
     * 下载原始复合导入模板
     * @param response
     * @throws IOException
     */
    @GetMapping("/download/composite/original")
    public void downloadOriginal(HttpServletResponse response) throws IOException {
        //获取输入流，原始模板位置
        String filePath = getClass().getResource("/download/ISAPCompositeOriginal.xlsx").getPath();
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
        //假如以中文名下载的话，设置下载文件名称
        String filename = "ISAP原始复合数据库.xlsx";
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

    /**
     * 原始复合批量导入
     * @param file
     * @return
     */
    @PostMapping("/composite/original/upload")
    @ResponseBody
    public int uploadOriginal(@RequestParam("file") MultipartFile file) {
        try {
            if (file != null) {
                //成功上传
                String fileName=file.getOriginalFilename();
                compositeService.uploadOriginal(file,fileName);
                return 1;
            } else {
                //文件为空
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //上传出现异常，请稍后重试
            return 3;
        }
    }

    /**
     * 批量导出原始复合
     * @param response
     * @throws IOException
     */
    @GetMapping("/export/composite/original")
    public void exportOriginal(HttpServletResponse response) throws IOException {
        //获取所有数据列表
        List<CompositeInput> list=compositeService.getOriginal();
        try{
            Workbook wb=new ExcelUtil().fillCompositeOriginal(list, "exportCompositeOriginal.xlsx");
            String fileName="ISAP复合库.xlsx";
            response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"iso8859-1"));
            response.setContentType("application/ynd.ms-excel;charset=UTF-8");
            OutputStream out=response.getOutputStream();
            wb.write(out);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
