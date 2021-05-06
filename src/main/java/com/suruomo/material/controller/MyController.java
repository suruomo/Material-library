package com.suruomo.material.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.suruomo.material.dao.*;
import com.suruomo.material.pojo.*;
import com.suruomo.material.service.AnalysisTaskService;
import com.suruomo.material.service.ModelTaskService;
import com.suruomo.material.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: suruomo
 * @date: 2021/2/1 16:42
 * @description:
 */
@Controller
@Slf4j
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

    @Resource
    private FlutterSpeedCrossingsResultMapper flutterSpeedCrossingsResultMapper;

    @Resource
    private FlutterVgComplexResultMapper flutterVgComplexResultMapper;

    @Resource
    private FlutterVgReALResultMapper flutterVgReALResultMapper;

    @Resource
    private ComplexFormMapper complexFormMapper;

    @Resource
    private RealFormMapper realFormMapper;

    @Resource
    private ModelTaskService modelTaskService;
    @Resource
    private AnalysisTaskService analysisTaskService;
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
     * 更新模型任务数据
     * @return
     */
    @RequestMapping(value = {"/task/model"},method = RequestMethod.PUT)
    public String updateModel(@RequestBody ModelTask task,Model model){
        System.out.println("进来修改模型");
        try{
            modelTaskService.updateByPrimaryKey(task);
            model.addAttribute("code",0);
            model.addAttribute("model",modelTaskMapper.selectByPrimaryKey(task.getId()));
            return "my/task_model_info";
        }catch (Exception e){
            model.addAttribute("code",1);
            model.addAttribute("model",modelTaskMapper.selectByPrimaryKey(task.getId()));
            return  "my/task_model_info";
        }
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
    public Map<String, Object> modelList(HttpServletRequest request,int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        // 获取用户
        User user = (User) request.getSession().getAttribute("user");
        List<ModelTask> lists = modelTaskMapper.getAll(user.getUserId(),start, end);
        return result.successResult(lists);
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
    @GetMapping(value = "/task/analysis/{id}", params = {"page", "limit"})
    public Map<String, Object> analysisList(@PathVariable BigDecimal id, int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        List<AnalysisTask> lists = analysisTaskMapper.getAll(id,start, end);
        return result.successResult(lists);
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
    @GetMapping(value = {"/task/analysis/{modelId}"})
    public String myTaskAnalysis(@PathVariable String modelId,Model model) {
        model.addAttribute("modelId",modelId);
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
        AnalysisTask analysisTask = analysisTaskMapper.selectByPrimaryKey(new BigDecimal(id));
        model.addAttribute("analysisTask", analysisTask);
        switch (type) {
            case "staticType":
                return "my/static_results";
            case "modeType":
                return "my/mode_results";
            case "flutterType":
                return "my/flutter_results";
            default:
                return "出错啦";
        }
    }

    /**
     * 返回静力分析的位移结果数据
     *
     * @param analysisId
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/static/results/distance/{analysisId}", params = {"page", "limit"})
    public Map<String, Object> distanceList(@PathVariable String analysisId, int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        BigDecimal id=new BigDecimal(analysisId);
        List<DistanceResult> lists = distanceResultMapper.getAll(id,start, end);
        return result.successResult(lists);
    }

    /**
     * 返回静力分析的约束反力数据
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/static/results/constrainForce/{analysisId}", params = {"page", "limit"})
    public Map<String, Object> constrainForceList(@PathVariable String analysisId, int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        BigDecimal id=new BigDecimal(analysisId);
        List<ConstrainForceResult> lists = constrainForceResultMapper.getAll(id,start, end);
        return result.successResult(lists);
    }

    /**
     * 返回静力分析的节点应力表
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/static/results/gridStress/{analysisId}", params = {"page", "limit"})
    public Map<String, Object> gridStressList(@PathVariable String analysisId, int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        BigDecimal id=new BigDecimal(analysisId);
        List<GridStressResult> lists = gridStressResultMapper.getAll(id,start, end);
        return result.successResult(lists);
    }

    /**
     * 返回静力分析的节点应变表
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/static/results/gridStrain/{analysisId}", params = {"page", "limit"})
    public Map<String, Object> gridStrainList(@PathVariable String analysisId, int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        BigDecimal id=new BigDecimal(analysisId);
        List<GridStrainResult> lists = gridStrainResultMapper.getAll(id,start, end);
        return result.successResult(lists);
    }

    /**
     * 返回正向模态的模态频率表
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/mode/results/frequency/{analysisId}", params = {"page", "limit"})
    public Map<String, Object> modeFrequencyList(@PathVariable String analysisId, int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        BigDecimal id=new BigDecimal(analysisId);
        List<ModeFrequencyResult> lists = modeFrequencyResultMapper.getAll(id,start, end);
        return result.successResult(lists);
    }

    /**
     * 返回正向模态的模态振型表
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/mode/results/shape/{analysisId}", params = {"page", "limit"})
    public Map<String, Object> modeShapeList(@PathVariable String analysisId, int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        BigDecimal id=new BigDecimal(analysisId);
        List<ModeShapeResult> lists = modeShapeResultMapper.getAll(id,start, end);
        return result.successResult(lists);
    }

    /**
     * 返回气动颤振的颤振速度交叉表
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/flutter/results/speed/{analysisId}", params = {"page", "limit"})
    public Map<String, Object> speedList(@PathVariable String analysisId,int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        BigDecimal id=new BigDecimal(analysisId);
        List<FlutterSpeedCrossingsResult> lists = flutterSpeedCrossingsResultMapper.getAll(id,start, end);
        return result.successResult(lists);
    }

    /**
     * 返回气动颤振的vg曲线数据详细表
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/flutter/results/complex/{analysisId}", params = {"page", "limit"})
    public Map<String, Object> complexList(@PathVariable String analysisId,int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        BigDecimal id=new BigDecimal(analysisId);
        List<FlutterVgComplexResult> lists = flutterVgComplexResultMapper.getAll(id,start, end);
        return result.successResult(lists);
    }

    /**
     * 返回气动颤振的vg实数根数据详细表
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/flutter/results/real/{analysisId}", params = {"page", "limit"})
    public Map<String, Object> realList(@PathVariable String analysisId,int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        BigDecimal id=new BigDecimal(analysisId);
        List<FlutterVgReALResult> lists = flutterVgReALResultMapper.getAll(id,start, end);
        return result.successResult(lists);
    }

    /**
     * 跳转complex详细数据页面
     *
     * @return
     */
    @GetMapping(value = {"/complex/{complexId}"})
    public String complexPage(@PathVariable String complexId, Model model) {
        model.addAttribute(complexId, complexId);
        return "my/complex_detail";
    }

    /**
     * 返回complex详细表
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/complex/detail/{complexId}", params = {"page", "limit"})
    public Map<String, Object> complexDetailList(@PathVariable String complexId, int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        List<ComplexForm> lists = complexFormMapper.getAll(complexId, start, end);
        return result.successResult(lists);
    }

    /**
     * 跳转real详细数据页面
     *
     * @return
     */
    @GetMapping(value = {"/real/{realId}"})
    public String realPage(@PathVariable String realId, Model model) {
        model.addAttribute(realId, realId);
        return "my/real_detail";
    }
    /**
     * 返回complex详细表
     *
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/real/detail/{realId}", params = {"page", "limit"})
    public Map<String, Object> realDetailList(@PathVariable String realId, int page, int limit) throws JsonProcessingException {
        int start = (page - 1) * limit + 1;
        int end = page * limit;
        List<RealForm> lists = realFormMapper.getAll(realId, start, end);
        return result.successResult(lists);
    }

    /**
     * 新建模型任务
     * @return
     */
    @ResponseBody
    @PostMapping(value ={"/task/model"})
    public int addModelTask(@RequestBody ModelTask modelTask){
        try{
            System.out.println("新建修改id"+modelTask.getId());
            ModelTask modelTask1=modelTaskMapper.selectByPrimaryKey(modelTask.getId());
            modelTask1.setGeometricModel(modelTask.getGeometricModel());
            modelTask1.setFiniteElementModel(modelTask.getFiniteElementModel());
            modelTask1.setName(modelTask.getName());
            modelTask1.setDescription(modelTask.getDescription());
            modelTask1.setUpdateTime(new Date());
            modelTaskService.updateByPrimaryKey(modelTask1);
            return 0;
        }catch (Exception e){
            return 1;
        }
    }

    /**
     * 新建分析任务
     * @return
     */
    @ResponseBody
    @PostMapping(value ={"/task/analysis"})
    public int addAnalysisTask(@RequestBody AnalysisTask analysisTask){
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            // 获取用户
            User user = (User) request.getSession().getAttribute("user");
            System.out.println("新建修改id"+analysisTask.getId());
            AnalysisTask analysisTask1=analysisTaskMapper.selectByPrimaryKey(analysisTask.getId());
            analysisTask1.setBeforePath(analysisTask.getBeforePath());
            analysisTask1.setResultPath(analysisTask.getResultPath());
            analysisTask1.setType(analysisTask.getType());
            analysisTask1.setModelId(analysisTask.getModelId());
            analysisTask1.setDescription(analysisTask.getDescription());
            analysisTask1.setUpdateTime(new Date());
            analysisTaskMapper.updateByPrimaryKey(analysisTask1);
            return 0;
        }catch (Exception e){
            return 1;
        }
    }

    /**
     * 下载几何模型文件
     * @param response
     * @throws IOException
     */
    @GetMapping("/download/geometricModel/{id}")
    public  void downloadGeometricModel(@PathVariable String id, HttpServletResponse response) throws IOException {
        ModelTask modelTask=modelTaskMapper.selectByPrimaryKey(new BigDecimal(id));
        String path=modelTask.getGeometricModel();
        if (path!=null){
            try{
                //假如以中文名下载的话，设置下载文件名称
                String[] strings=path.split("/");
                String filename = strings[strings.length-1];
                //解码，免得文件名中文乱码
                filename = URLDecoder.decode(filename, "UTF-8");
                //获取文件位置
                String filePath = getClass().getResource(modelTask.getGeometricModel()).getPath();
                filePath = URLDecoder.decode(filePath, "UTF-8");
                InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
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
            }catch (Exception e){
                // 没有该文件
                response.reset();
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().print("<script type='text/javascript'>alert('下载几何模型出错');location.href='/task/model/" + id + "'</script>");
                response.getWriter().close();
            }
        }else {
            // 没有该文件
            response.reset();
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<script type='text/javascript'>alert('文件不存在');location.href='/task/model/" + id + "'</script>");
            response.getWriter().close();
        }

    }


    /**
     * 下载有限元模型文件
     * @param response
     * @throws IOException
     */
    @GetMapping("/download/finiteElementModel/{id}")
    public void downloadFiniteElementModel(@PathVariable String id, HttpServletResponse response) throws IOException {
        ModelTask modelTask=modelTaskMapper.selectByPrimaryKey(new BigDecimal(id));
        String path=modelTask.getGeometricModel();
        if (path!=null){
            try {
                //假如以中文名下载的话，设置下载文件名称
                String[] strings=modelTask.getFiniteElementModel().split("/");
                String filename = strings[strings.length-1];
                //解码，免得文件名中文乱码
                filename = URLDecoder.decode(filename, "UTF-8");
                //获取文件位置
                String filePath = getClass().getResource(modelTask.getFiniteElementModel()).getPath();
                filePath = URLDecoder.decode(filePath, "UTF-8");
                InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
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
            }catch (Exception e){
                // 没有该文件
                response.reset();
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().print("<script type='text/javascript'>alert('下载有限元模型出错');location.href='/task/model/" + id + "'</script>");
                response.getWriter().close();
            }
        }else {
            // 没有该文件
            response.reset();
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<script type='text/javascript'>alert('文件不存在');location.href='/task/model/" + id + "'</script>");
            response.getWriter().close();
        }
    }
    /**
     * 下载前处理文件
     * @param response
     * @throws IOException
     */
    @GetMapping("/download/beforeFile/{id}")
    public void downloadBeforeFile(@PathVariable String id, HttpServletResponse response) throws IOException {
        AnalysisTask analysisTask=analysisTaskMapper.selectByPrimaryKey(new BigDecimal(id));
        String path=analysisTask.getBeforePath();
        if (path!=null){
            try {
                //假如以中文名下载的话，设置下载文件名称
                String[] strings=analysisTask.getBeforePath().split("/");
                String filename = strings[strings.length-1];
                //解码，免得文件名中文乱码
                filename = URLDecoder.decode(filename, "UTF-8");
                //获取文件位置
                String filePath = getClass().getResource(analysisTask.getBeforePath()).getPath();
                filePath = URLDecoder.decode(filePath, "UTF-8");
                InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
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
            }catch (Exception e){
                // 没有该文件
                response.reset();
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().print("<script type='text/javascript'>alert('下载前处理文件出错');location.href='/task/model/" + analysisTask.getModelId() + "'</script>");
                response.getWriter().close();
            }
        }else {
            // 没有该文件
            response.reset();
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<script type='text/javascript'>alert('文件不存在');location.href='/task/model/" + analysisTask.getModelId() + "'</script>");
            response.getWriter().close();
        }
    }

    /**
     * 下载结果文件
     * @param response
     * @throws IOException
     */
    @GetMapping("/download/resultFile/{id}")
    public void downloadResultFile(@PathVariable String id, HttpServletResponse response) throws IOException {
        AnalysisTask analysisTask=analysisTaskMapper.selectByPrimaryKey(new BigDecimal(id));
        String path=analysisTask.getResultPath();
        if (path!=null){
            try {
                //假如以中文名下载的话，设置下载文件名称
                String[] strings=analysisTask.getResultPath().split("/");
                String filename = strings[strings.length-1];
                //解码，免得文件名中文乱码
                filename = URLDecoder.decode(filename, "UTF-8");
                //获取文件位置
                String filePath = getClass().getResource(analysisTask.getResultPath()).getPath();
                filePath = URLDecoder.decode(filePath, "UTF-8");
                InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
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
            }catch (Exception e){
                // 没有该文件
                response.reset();
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().print("<script type='text/javascript'>alert('下载结果文件出错');location.href='/task/model/" + analysisTask.getModelId() + "'</script>");
                response.getWriter().close();
            }
        }else {
            // 没有该文件
            response.reset();
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<script type='text/javascript'>alert('文件不存在');location.href='/task/model/" + analysisTask.getModelId() + "'</script>");
            response.getWriter().close();
        }
    }
}
