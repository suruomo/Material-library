package com.suruomo.material.controller;

import com.suruomo.material.pojo.User;
import com.suruomo.material.service.AnalysisTaskService;
import com.suruomo.material.service.ModelTaskService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: suruomo
 * @date: 2021/2/15 21:54s
 * @description: 上传文件
 */
@Controller
public class UploadController {
    @Resource
    private ModelTaskService modelTaskService;
    @Resource
    private AnalysisTaskService analysisTaskService;
    /**
     * 绝对路径
     */
    private String rootPath="";
    /**
     * 静态资源目录
     */
    private String staticDir="/static";
    /**
     * 文件存放目录
     */
    private String fileDir="/upload/";
    /**
     * 上传几何模型
     * @param file
     * @return
     */
    @PostMapping("/upload/geometricModel")
    @ResponseBody
    public Map<String, Object> uploadGeometricModel(HttpServletRequest request,@RequestParam("file") MultipartFile file) {
        HashMap<String,Object> map=new HashMap<>();
        int id=0;
        try {
            if (file != null) {
                // 获取用户
                User user = (User) request.getSession().getAttribute("user");
                // 创建新模型任务，返回任务id
                int modelId=modelTaskService.addModel(user.getUserId());
                id=modelId;
                request.getSession().setAttribute("modelId",String.valueOf(modelId));
                //文件上传的地址
                String path = rootPath +staticDir+fileDir+user.getUserId()+"/"+modelId+"/geometricModel";
                String realPath = path.replace('/', '\\').substring(1, path.length());
                System.out.println("目录："+realPath);
                //获取文件的名称
                final String fileName = file.getOriginalFilename();
                // 要先创建目录再创建文件否则报错
                File dirPath=new File(realPath);
                if (!dirPath.exists()){
                    dirPath.mkdirs();
                }
                File filePath = new File(realPath, fileName);
                if(!filePath.exists()) {
                    try {
                        filePath.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //完成文件的上传
                InputStream inputStream=file.getInputStream();
                FileUtils.copyInputStreamToFile(inputStream,filePath);
                System.out.println("文件上传成功!");
                String path01 = staticDir+fileDir+user.getUserId()+"/"+modelId+"/geometricModel/"+fileName;
                System.out.println("文件路径是" + path01);
                map.put("code", 1);
                map.put("msg", "成功");
                map.put("data", path01);
                map.put("modelId", modelId);
            } else {
                //文件为空
                map.put("code", 0);
                map.put("msg", "文件为空");
                map.put("data", null);
            }
            map.put("count", 1);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            // 失败了删除未创建成功数据
            modelTaskService.deleteByPrimaryKey(id);
            //上传出现异常，请稍后重试
            map.put("code", 2);
            map.put("msg", "文件上传异常");
            map.put("data", null);
            map.put("count", 1);
            return map;
        }
    }
    /**
     * 上传有限元模型
     * @param file
     * @return
     */
    @PostMapping("/upload/finiteElementModel")
    @ResponseBody
    public Map<String, Object> uploadFiniteElementModel(HttpServletRequest request,@RequestParam("file") MultipartFile file) {
        HashMap<String,Object> map=new HashMap<>();
        try {
            if (file != null) {
                // 获取用户
                User user = (User) request.getSession().getAttribute("user");
                String modelId=(String)request.getSession().getAttribute("modelId");
                //文件上传的地址
                String path = rootPath +staticDir+fileDir+user.getUserId()+"/"+modelId+"/finiteElementModel";
                String realPath = path.replace('/', '\\').substring(1, path.length());
                //获取文件的名称
                final String fileName = file.getOriginalFilename();
                // 要先创建目录再创建文件否则报错
                File dirPath=new File(realPath);
                if (!dirPath.exists()){
                    dirPath.mkdirs();
                }
                File filePath = new File(realPath, fileName);
                if(!filePath.exists()) {
                    try {
                        filePath.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //完成文件的上传
                InputStream inputStream=file.getInputStream();
                FileUtils.copyInputStreamToFile(inputStream,filePath);
                System.out.println("文件上传成功!");
                String path01 = staticDir+fileDir+user.getUserId()+"/"+modelId+"/finiteElementModel/"+fileName;
                System.out.println("文件路径是" + path01);
                map.put("code", 1);
                map.put("msg", "成功");
                map.put("data", path01);
            } else {
                //文件为空
                map.put("code", 0);
                map.put("msg", "文件为空");
                map.put("data", null);
            }
            map.put("count", 1);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            //上传出现异常，请稍后重试
            map.put("code", 2);
            map.put("msg", "文件上传异常");
            map.put("data", null);
            map.put("count", 1);
            return map;
        }
    }
    /**
     * 重新上传几何模型
     * @param file
     * @return
     */
    @PostMapping("/reload/geometricModel")
    @ResponseBody
    public Map<String, Object> reloadGeometricModel(HttpServletRequest request,@RequestParam("file") MultipartFile file
            ,@RequestParam("modelId")String modelId) {
        HashMap<String,Object> map=new HashMap<>();
        try {
            if (file != null) {
                // 获取用户
                User user = (User) request.getSession().getAttribute("user");
                //文件上传的地址
                String path =  rootPath +staticDir+fileDir+user.getUserId()+"/"+modelId+"/geometricModel";
                String realPath = path.replace('/', '\\').substring(1, path.length());
                //获取文件的名称
                final String fileName = file.getOriginalFilename();
                // 要先创建目录再创建文件否则报错
                File dirPath=new File(realPath);
                if (!dirPath.exists()){
                    dirPath.mkdirs();
                }
                File filePath = new File(realPath, fileName);
                if(!filePath.exists()) {
                    try {
                        filePath.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //完成文件的上传
                InputStream inputStream=file.getInputStream();
                FileUtils.copyInputStreamToFile(inputStream,filePath);
                System.out.println("文件上传成功!");
                String path01 = staticDir+fileDir+user.getUserId()+"/"+modelId+"/geometricModel/"+fileName;
                System.out.println("文件路径是" + path01);
                map.put("code", 1);
                map.put("msg", "成功");
                map.put("data", path01);
                map.put("modelId", modelId);
            } else {
                //文件为空
                map.put("code", 0);
                map.put("msg", "文件为空");
                map.put("data", null);
            }
            map.put("count", 1);
            return map;
        } catch (Exception e) {
            //上传出现异常，请稍后重试
            map.put("code", 2);
            map.put("msg", "文件上传异常");
            map.put("data", null);
            map.put("count", 1);
            return map;
        }
    }

    /**
     * 重新上传有限元模型
     * @param file
     * @return
     */
    @PostMapping("/reload/finiteElementModel")
    @ResponseBody
    public Map<String, Object> reloadFiniteElementModel(HttpServletRequest request,@RequestParam("file") MultipartFile file
            ,@RequestParam("modelId")String modelId) {
        HashMap<String,Object> map=new HashMap<>();
        try {
            if (file != null) {
                // 获取用户
                User user = (User) request.getSession().getAttribute("user");
                //文件上传的地址
                String path =  rootPath +staticDir+fileDir+user.getUserId()+"/"+modelId+"/finiteElementModel";
                String realPath = path.replace('/', '\\').substring(1, path.length());
                //获取文件的名称
                final String fileName = file.getOriginalFilename();
                // 要先创建目录再创建文件否则报错
                File dirPath=new File(realPath);
                if (!dirPath.exists()){
                    dirPath.mkdirs();
                }
                File filePath = new File(realPath, fileName);
                if(!filePath.exists()) {
                    try {
                        filePath.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //完成文件的上传
                InputStream inputStream=file.getInputStream();
                FileUtils.copyInputStreamToFile(inputStream,filePath);
                System.out.println("文件上传成功!");
                String path01 =staticDir+fileDir+user.getUserId()+"/"+modelId+"/finiteElementModel/"+fileName;
                System.out.println("文件路径是" + path01);
                map.put("code", 1);
                map.put("msg", "成功");
                map.put("data", path01);
            } else {
                //文件为空
                map.put("code", 0);
                map.put("msg", "文件为空");
                map.put("data", null);
            }
            map.put("count", 1);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            //上传出现异常，请稍后重试
            map.put("code", 2);
            map.put("msg", "文件上传异常");
            map.put("data", null);
            map.put("count", 1);
            return map;
        }
    }
    /**
     * 上传前处理文件
     * @param file
     * @return
     */
    @PostMapping("/upload/beforeFile")
    @ResponseBody
    public Map<String, Object> uploadBeforeFile(HttpServletRequest request,@RequestParam("file") MultipartFile file
            ,@RequestParam("modelId")String modelId) {
        HashMap<String,Object> map=new HashMap<>();
        try {
            if (file != null) {
                // 获取用户
                User user = (User) request.getSession().getAttribute("user");
                // 创建新模型任务，返回任务id
                int analysisId=analysisTaskService.addAnalysis(user.getUserId());
                request.getSession().setAttribute("analysisId",String.valueOf(analysisId));
                //文件上传的地址
                String path =  rootPath +staticDir+fileDir+user.getUserId()+"/"+modelId+"/"+analysisId+"/beforeFile";
                String realPath = path.replace('/', '\\').substring(1, path.length());
                //获取文件的名称
                final String fileName = file.getOriginalFilename();
                // 要先创建目录再创建文件否则报错
                File dirPath=new File(realPath);
                if (!dirPath.exists()){
                    dirPath.mkdirs();
                }
                File filePath = new File(realPath, fileName);
                if(!filePath.exists()) {
                    try {
                        filePath.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //完成文件的上传
                InputStream inputStream=file.getInputStream();
                FileUtils.copyInputStreamToFile(inputStream,filePath);
                System.out.println("文件上传成功!");
                String path01 =staticDir+fileDir+user.getUserId()+"/"+modelId+"/"+analysisId+"/beforeFile/"+fileName;
                System.out.println("文件路径是" + path01);
                map.put("code", 1);
                map.put("msg", "成功");
                map.put("data", path01);
                map.put("analysisId", analysisId);
            } else {
                //文件为空
                map.put("code", 0);
                map.put("msg", "文件为空");
                map.put("data", null);
            }
            map.put("count", 1);
            return map;
        } catch (Exception e) {
            //上传出现异常，请稍后重试
            map.put("code", 2);
            map.put("msg", "文件上传异常");
            map.put("data", null);
            map.put("count", 1);
            return map;
        }
    }
    /**
     * 上传结果文件
     * @param file
     * @return
     */
    @PostMapping("/upload/resultFile")
    @ResponseBody
    public Map<String, Object> uploadResultFile(HttpServletRequest request,@RequestParam("file") MultipartFile file
            ,@RequestParam("modelId")String modelId) {
        HashMap<String,Object> map=new HashMap<>();
        try {
            if (file != null) {
                // 获取用户
                User user = (User) request.getSession().getAttribute("user");
                String analysisId=(String)request.getSession().getAttribute("analysisId");
                //文件上传的地址
                String path =  rootPath +staticDir+fileDir+user.getUserId()+"/"+modelId+"/"+analysisId+"/resultFile";
                String realPath = path.replace('/', '\\').substring(1, path.length());
                //获取文件的名称
                final String fileName = file.getOriginalFilename();
                //限制文件上传的类型
                // String contentType = file.getContentType();
                // 要先创建目录再创建文件否则报错
                File dirPath=new File(realPath);
                if (!dirPath.exists()){
                    dirPath.mkdirs();
                }
                File filePath = new File(realPath, fileName);
                if(!filePath.exists()) {
                    try {
                        filePath.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //完成文件的上传
                InputStream inputStream=file.getInputStream();
                FileUtils.copyInputStreamToFile(inputStream,filePath);
                System.out.println("文件上传成功!");
                String path01 = staticDir+fileDir+user.getUserId()+"/"+modelId+"/"+analysisId+"/resultFile/"+fileName;
                System.out.println("文件路径是" + path01);
                map.put("code", 1);
                map.put("msg", "成功");
                map.put("data", path01);
            } else {
                //文件为空
                map.put("code", 0);
                map.put("msg", "文件为空");
                map.put("data", null);
            }
            map.put("count", 1);
            return map;
        } catch (Exception e) {
            //上传出现异常，请稍后重试
            map.put("code", 2);
            map.put("msg", "文件上传异常");
            map.put("data", null);
            map.put("count", 1);
            return map;
        }
    }
}
