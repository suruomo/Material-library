package com.suruomo.material.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.suruomo.material.aop.SystemLog;
import com.suruomo.material.dao.LayupMapper;
import com.suruomo.material.dto.Pcomp;
import com.suruomo.material.pojo.Layup;
import com.suruomo.material.service.LayupService;
import com.suruomo.material.utils.ExcelUtil;
import com.suruomo.material.utils.ExportPcomp;
import com.suruomo.material.utils.Result;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author 苏若墨
 */
@Controller
public class LayupController {
    @Resource
    private LayupMapper layupMapper;
    @Resource
    private LayupService layupService;
    @Resource
    private Result result;

    /**
     * 跳转材料卡数据列表页面
     * @return
     */
    @GetMapping("/layups/card/list")
    public String layups() {
        return "layup/card_list";
    }

    /**
     * 跳转管理员铺层页面
     * @return
     */
    @GetMapping("/admin/layup")
    public String layupList() {
        return "admin/layup/list";
    }

    /**
     * 跳转管理员铺层详情页面
     * @return
     */
    @GetMapping("/admin/layup/{name}")
    public String layupInfo(@PathVariable String name, Model model) {
        Layup layup=layupMapper.selectByPrimaryKey(name);
        model.addAttribute("layup",layup);
        return "admin/layup/info";
    }

    /**
     * 跳转ISAP铺层列表页面
     * @return
     */
    @GetMapping("/layups/isap/list")
    public String layupIsapList() {
        return "layup/isap_list";
    }
    /**
     * 删除铺层数据
     * @param name
     * @param model
     * @return
     */
    @DeleteMapping ("/admin/layup/{name}")
    @ResponseBody
    public String deleteCard(@PathVariable String name, Model model) {
        layupMapper.deleteByPrimaryKey(name);
        return "success";
    }
    /**
     * 返回ISAP铺层数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/layups/isap/data",params = {"page","limit"})
    public Map<String, Object> layup(int page,  int limit) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<Layup> lists = layupMapper.getAll(start, end);
        int allCount=layupMapper.getCount();
        return result.successResult(lists,allCount);
    }

    /**
     * ISAP数据按名称查找
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/layups/isap/data",params = {"page","limit","name"})
    public Map<String, Object> getByName(int page,  int limit,String name) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<Layup> lists = layupMapper.getByName(start, end,name);
        return result.successResult(lists);
    }
    /**
     * 跳转至导出PCOMP页面
     * @return
     */

    @GetMapping("/layup/export/{id}")
    public String mat(@PathVariable String id, Model model) {
        Layup layup=layupMapper.selectByPrimaryKey(id);
        model.addAttribute("layup",layup);
        return "layup/pcomp";
    }

    /**
     * 跳转至ISAP铺层数据详情页面
     * @return
     */

    @GetMapping("/layups/isap/{name}")
    public String isapInfo(@PathVariable String name, Model model) {
        Layup layup=layupMapper.selectByPrimaryKey(name);
        model.addAttribute("layup",layup);
        return "layup/isap_info";
    }
    /**
     * 导出PCOMP卡片.bdf文件下载
     */
    @PostMapping("/export/pcomp")
    public void exportPcomp(Pcomp pcomp, HttpServletResponse response) throws IOException {
        ExportPcomp exportPcomp=new ExportPcomp();
        System.out.println(pcomp.toString());
        //获取输入流，
        InputStream bis = new BufferedInputStream(new FileInputStream(exportPcomp.export(pcomp)));
        //假如以中文名下载的话，设置下载文件名称
        String filename = pcomp.getID()+"导出PCOMP卡片.bdf";
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
     * 下载铺层库导入模板
     * @param response
     * @throws IOException
     */
    @GetMapping("/download/template")
    public void downloadCardl(HttpServletResponse response) throws IOException {
        //获取输入流，原始模板位置
        String filePath = getClass().getResource("/download/ISAPLayupTemplate.xlsx").getPath();
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
        //假如以中文名下载的话，设置下载文件名称
        String filename = "ISAP铺层库导入模板.xlsx";
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
     * 铺层库批量导入
     * @param file
     * @return
     */
    @SystemLog(module = "操作：管理员上传数据")
    @PostMapping("/layup/upload")
    @ResponseBody
    public int upload(@RequestParam("file") MultipartFile file) {
        try {
            if (file != null) {
                //成功上传
                String fileName=file.getOriginalFilename();
                layupService.upload(file,fileName);
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
     * 批量导出铺层库
     * @param response
     * @throws IOException
     */
    @GetMapping("/export/layups")
    public void exportLayups(HttpServletResponse response) throws IOException {
        //获取所有数据列表
        List<Layup> list=layupService.getCard();
        try{
            Workbook wb=new ExcelUtil().fillLayup(list, "exportLayup.xlsx");
            String fileName="ISAP铺层库.xlsx";
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
