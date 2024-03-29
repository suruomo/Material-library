package com.suruomo.material.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.suruomo.material.aop.SystemLog;
import com.suruomo.material.dao.MetalInputMapper;
import com.suruomo.material.dao.MetalOutMapper;
import com.suruomo.material.dto.Mat1;
import com.suruomo.material.pojo.MetalInput;
import com.suruomo.material.pojo.MetalOut;
import com.suruomo.material.service.MetalService;
import com.suruomo.material.utils.ExcelUtil;
import com.suruomo.material.utils.ExportMat1;
import com.suruomo.material.utils.Result;
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
import java.util.List;
import java.util.Map;

/**
 * @author 苏若墨
 */
@Controller
public class MetalController {
    @Resource
    private MetalOutMapper metalOutMapper;
    @Resource
    private MetalInputMapper metalInputMapper;
    @Resource
    private MetalService metalService;
    @Resource
    private Result result;

    /**
     * 跳转ISAP数据列表页面
     * @return
     */
    @GetMapping("/metals/isap/list")
    public String rawDatas() {
        return "metal/isap_list";
    }
    /**
     * 跳转材料卡列表页面
     * @return
     */
    @GetMapping("/metals/card/list")
    public String aluminumList(Model model) {
        model.addAttribute("type","aluminum");
        return "metal/card_list";
    }
    /**
     * 跳转所有钢数据列表页面
     * @return
     */
    @GetMapping("/metal/steel")
    public String steelList(Model model) {
        model.addAttribute("type","steel");
        return "card_list";
    }

    /**
     * 删除原始数据
     * @param id
     * @param model
     * @return
     */
    @SystemLog(module = "操作：管理员删除数据")
    @DeleteMapping ("/metal/original/{id}")
    @ResponseBody
    public String deleteOriginal(@PathVariable String id, Model model) {
        metalInputMapper.deleteByPrimaryKey(new BigDecimal(id));
        return "success";
    }

    /**
     * 删除材料卡数据
     * @param id
     * @param model
     * @return
     */
    @SystemLog(module = "操作：管理员删除数据")
    @DeleteMapping ("/metal/card/{id}")
    @ResponseBody
    public String deleteCard(@PathVariable String id, Model model) {
        metalOutMapper.deleteByPrimaryKey(new BigDecimal(id));
        return "success";
    }
    /**
     * 跳转所有钛数据列表页面
     * @return
     */
    @GetMapping("/metal/titanium")
    public String titaniumList(Model model) {
        model.addAttribute("type","titanium");
        return "card_list";
    }

    /**
     * 跳转管理员原始数据列表页面
     * @return
     */
    @GetMapping("/admin/metal/original")
    public String originalList() {
        return "admin/metal/originalList";
    }

    /**
     * 跳转管理员材料卡数据列表页面
     * @return
     */
    @GetMapping("/admin/metal/card")
    public String cardList() {
        return "admin/metal/cardList";
    }

    /**
     * 返回全部ISAP金属数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/metals/isap/data",params = {"page","limit"})
    public Map<String, Object> mentals( int page, int limit) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<MetalInput> lists = metalInputMapper.getAll(start, end);
        int allCount=metalInputMapper.getCount();
        return result.successResult(lists,allCount);
    }
    /**
     * 根据条件筛选ISAP金属列表
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/metals/isap/data",params = {"page","limit","typeName","family","temper"})
    public Map<String, Object> mentalsReload( int page,  int limit,String typeName,String family,String temper) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<MetalInput> lists;
        int allCount=0;
        if(!typeName.equals(" ")&&family.equals(" ")){
            lists = metalInputMapper.getAllByType(start, end,typeName);
            allCount=metalInputMapper.getTypeCount(typeName);
        }
        else if(!typeName.equals(" ")&&!family.equals(" ")&&temper.equals(" ")){
            lists = metalInputMapper.getAllDataByNT(start, end,typeName,family);
            allCount=metalInputMapper.getTypeFamilyCount(typeName,family);
        }
        else{
            lists = metalInputMapper.getAllDataByCondition(start, end,typeName,family,temper);
            allCount=metalInputMapper.getTypeFamilyTemperCount(typeName,family,temper);
        }
        return result.successResult(lists,allCount);
    }
    /**
     * 返回金属材料卡数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/metal/cards",params = {"page","limit"})
    public Map<String, Object> cards( int page,  int limit) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<MetalOut> lists = metalOutMapper.getAllData(start, end);
        int allCount=metalOutMapper.getAllCount();
        return result.successResult(lists,allCount);
    }

    /**
     * 下载原始金属导入模板
     * @param response
     * @throws IOException
     */
    @GetMapping("/download/metal/original")
    public void downloadOriginal(HttpServletResponse response) throws IOException {
        //获取输入流，原始模板位置
        String filePath = getClass().getResource("/download/ISAPMetalOriginal.xlsx").getPath();
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
        //假如以中文名下载的话，设置下载文件名称
        String filename = "ISAP原始金属数据库.xlsx";
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
     * 根据类型查family
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping(value = "admin/metal/query",params = "typeName")
    public Map<String, Object> queryFamily(String typeName) throws JsonProcessingException {
        List<String> lists = metalOutMapper.getFamily(typeName);
        return result.successResult(lists);
    }
    /**
     * ISAP根据类型查family
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping(value = "/metals/isap/query",params = "typeName")
    public Map<String, Object> queryByFamily(String typeName) throws JsonProcessingException {
        List<String> lists = metalInputMapper.getFamily(typeName);
        return result.successResult(lists);
    }
    /**
     * 材料卡根据类型查family
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping(value = "/metals/card/query",params = "typeName")
    public Map<String, Object> queryCardByTypeName(String typeName) throws JsonProcessingException {
        List<String> lists = metalOutMapper.getFamily(typeName);
        return result.successResult(lists);
    }
    /**
     * 根据family查temper
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping(value = "/metals/card/query",params = "family")
    public Map<String, Object> queryCardByFamily(String family) throws JsonProcessingException {
        List<String> lists = metalOutMapper.getTemper(family);
        return result.successResult(lists);
    }
    /**
     * 根据family查temper
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping(value = "admin/metal/query",params = "family")
    public Map<String, Object> queryTemper(String family) throws JsonProcessingException {
        List<String> lists = metalOutMapper.getTemper(family);
        return result.successResult(lists);
    }
    /**
     * 根据family查temper
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @RequestMapping(value = "/metals/isap/query",params = "family")
    public Map<String, Object> queryByTemper(String family) throws JsonProcessingException {
        List<String> lists = metalInputMapper.getTemper(family);
        return result.successResult(lists);
    }
    /**
     * 下载材料卡导入模板
     * @param response
     * @throws IOException
     */
    @GetMapping("/download/metal/card")
    public void downloadCard(HttpServletResponse response) throws IOException {
        //获取输入流，原始模板位置
        String filePath = getClass().getResource("/download/MetalCardTemplate.xlsx").getPath();
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
        //假如以中文名下载的话，设置下载文件名称
        String filename = "金属材料卡库导入模板.xlsx";
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
     * 根据组合条件返回材料卡金属数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/metals/card/{type}",params = {"page","limit","typeName","family","temper"})
    public Map<String, Object> listByCondition(int page,  int limit,@PathVariable("type") String type,String typeName,String family,String temper) throws JsonProcessingException {
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<MetalOut> lists;
        int allCount=0;
        if(!typeName.equals(" ")&&family.equals(" ")){
            lists = metalOutMapper.getAll(start, end,typeName);
            allCount=metalOutMapper.getTypeCount(typeName);
        }
        else if(!typeName.equals(" ")&&!family.equals(" ")&&temper.equals(" ")){
            lists = metalOutMapper.getAllDataByNT(start, end,typeName,family);
            allCount=metalOutMapper.getTwoCondition(typeName,family);
        }
        else{
            lists = metalOutMapper.getAllDataByCondition(start, end,typeName,family,temper);
            allCount=metalOutMapper.getThreeCondition(typeName,family,temper);
        }
        return result.successResult(lists,allCount);
    }

    /**
     * 根据类型查询材料卡
     * @param page
     * @param limit
     * @param type
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/metals/card/{type}",params = {"page","limit"})
    public Map<String, Object> list(int page,  int limit,@PathVariable("type") String type) throws JsonProcessingException {
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
        List<MetalOut> lists = metalOutMapper.getAll(start, end,queryType);
        int allCount=metalOutMapper.getCount(queryType);
        return result.successResult(lists,allCount);
    }
    /**
     * 跳转至ISAP金属详细信息页面
     * @return
     */
    @GetMapping("/metals/isap/{id}")
    public String getMetalIsapInfo(@PathVariable String id, Model model) {
        MetalInput metalInput=metalInputMapper.selectByPrimaryKey(new BigDecimal(id));
        model.addAttribute("metal",metalInput);
        return "metal/isap_info";
    }


    @GetMapping("/metal/original/{id}")
    public String originalInfo(@PathVariable String id, Model model) {
        MetalInput metalInput=metalInputMapper.selectByPrimaryKey(new BigDecimal(id));
        model.addAttribute("metal",metalInput);
        return "admin/metal/originalInfo";
    }

    @GetMapping("/metal/card/{id}")
    public String cardInfo(@PathVariable String id, Model model) {
        MetalOut metalOut=metalOutMapper.selectByPrimaryKey(new BigDecimal(id));
        model.addAttribute("metal",metalOut);
        return "admin/metal/cardInfo";
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

    /**
     * 批量导出原始数据
     * @param response
     * @throws IOException
     */
    @GetMapping("/export/metal/original")
    public void exportOriginal(HttpServletResponse response) throws IOException {
        //获取所有数据列表
        List<MetalInput> list=metalService.getAll();
        try{
            Workbook wb=new ExcelUtil().fillMetalOriginal(list, "exportMetalOriginal .xlsx");
            String fileName="ISAP金属库.xlsx";
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

    /**
     * 批量导出材料卡
     * @param response
     * @throws IOException
     */
    @GetMapping("/export/metal/card")
    public void exportCard(HttpServletResponse response) throws IOException {
        //获取所有数据列表
        List<MetalOut> list=metalService.getAllOut();
        try{
            Workbook wb=new ExcelUtil().fillMetalCard(list, "exportMetalCard.xlsx");
            String fileName="金属材料卡导出库.xlsx";
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
    /**
     * 原始金属批量导入
     * @param file
     * @return
     */
    @SystemLog(module = "操作：管理员上传数据")
    @PostMapping("/metal/original/upload")
    @ResponseBody
    public int uploadOriginal(@RequestParam("file") MultipartFile file) {
        try {
            if (file != null) {
                //成功上传
                String fileName=file.getOriginalFilename();
                metalService.uploadOriginal(file,fileName);
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
     * 材料卡数据批量导入
     * @param file
     * @return
     */
    @SystemLog(module = "操作：管理员上传数据")
    @PostMapping("/metal/card/upload")
    @ResponseBody
    public int uploadCard(@RequestParam("file") MultipartFile file) {
        try {
            if (file != null) {
                //成功上传
                String fileName=file.getOriginalFilename();
                metalService.uploadCard(file,fileName);
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
}
