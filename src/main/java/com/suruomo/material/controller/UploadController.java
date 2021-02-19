package com.suruomo.material.controller;

import com.suruomo.material.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: suruomo
 * @date: 2021/2/15 21:54s
 * @description: 上传文件
 */
@Controller
public class UploadController {
    /**
     * 上传几何模型
     * @param file
     * @return
     */
    @PostMapping("/upload/geometricModel")
    @ResponseBody
    public Map<String, Object> uploadGeometricModel(@RequestParam("file") MultipartFile file) {
        HashMap<String,Object> map=new HashMap<>();
        try {
            if (file != null) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                // 获取用户
                User user = (User) request.getSession().getAttribute("user");
                //文件上传的地址
                String path = ResourceUtils.getURL("classpath:").getPath() + "static/upload/"+user.getUserId()+"/geometricModel";
                String realPath = path.replace('/', '\\').substring(1, path.length());
                //用于查看路径是否正确
//                System.out.println(realPath);
                //获取文件的名称
                final String fileName = file.getOriginalFilename();
                //限制文件上传的类型
                // String contentType = file.getContentType();
                File file1 = new File(realPath, fileName);
                if(!file1.exists()) {
                    file1.mkdirs();
                }
                //完成文件的上传
                file.transferTo(file1);
                System.out.println("文件上传成功!");
                String path01 = "/static/upload/" +user.getUserId()+"/geometricModel/"+fileName;
//                System.out.println("文件路径是" + path01);
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
    /**
     * 上传有限元模型
     * @param file
     * @return
     */
    @PostMapping("/upload/finiteElementModel")
    @ResponseBody
    public Map<String, Object> uploadFiniteElementModel(@RequestParam("file") MultipartFile file) {
        HashMap<String,Object> map=new HashMap<>();
        try {
            if (file != null) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                // 获取用户
                User user = (User) request.getSession().getAttribute("user");
                //文件上传的地址
                String path = ResourceUtils.getURL("classpath:").getPath() + "static/upload/"+user.getUserId()+"/finiteElementModel";
                String realPath = path.replace('/', '\\').substring(1, path.length());
                //用于查看路径是否正确
                System.out.println(realPath);
                //获取文件的名称
                final String fileName = file.getOriginalFilename();
                //限制文件上传的类型
                // String contentType = file.getContentType();
                File file1 = new File(realPath, fileName);
                if(!file1.exists()) {
                    file1.mkdirs();
                }
                //完成文件的上传
                file.transferTo(file1);
                System.out.println("文件上传成功!");
                String path01 = "/static/upload/" +user.getUserId()+"/finiteElementModel/"+fileName;
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

    /**
     * 上传前处理文件
     * @param file
     * @return
     */
    @PostMapping("/upload/beforeFile")
    @ResponseBody
    public Map<String, Object> uploadBeforeFile(@RequestParam("file") MultipartFile file) {
        HashMap<String,Object> map=new HashMap<>();
        try {
            if (file != null) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                // 获取用户
                User user = (User) request.getSession().getAttribute("user");
                //文件上传的地址
                String path = ResourceUtils.getURL("classpath:").getPath() + "static/upload/"+user.getUserId()+"/beforeFile";
                String realPath = path.replace('/', '\\').substring(1, path.length());
                //用于查看路径是否正确
//                System.out.println(realPath);
                //获取文件的名称
                final String fileName = file.getOriginalFilename();
                //限制文件上传的类型
                // String contentType = file.getContentType();
                File file1 = new File(realPath, fileName);
                if(!file1.exists()) {
                    file1.mkdirs();
                }
                //完成文件的上传
                file.transferTo(file1);
                System.out.println("文件上传成功!");
                String path01 = "/static/upload/" +user.getUserId()+"/beforeFile/"+fileName;
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
    /**
     * 上传结果文件
     * @param file
     * @return
     */
    @PostMapping("/upload/resultFile")
    @ResponseBody
    public Map<String, Object> uploadResultFile(@RequestParam("file") MultipartFile file) {
        HashMap<String,Object> map=new HashMap<>();
        try {
            if (file != null) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                // 获取用户
                User user = (User) request.getSession().getAttribute("user");
                //文件上传的地址
                String path = ResourceUtils.getURL("classpath:").getPath() + "static/upload/"+user.getUserId()+"/resultFile";
                String realPath = path.replace('/', '\\').substring(1, path.length());
                //用于查看路径是否正确
                System.out.println(realPath);
                //获取文件的名称
                final String fileName = file.getOriginalFilename();
                //限制文件上传的类型
                // String contentType = file.getContentType();
                File file1 = new File(realPath, fileName);
                if(!file1.exists()) {
                    file1.mkdirs();
                }
                //完成文件的上传
                file.transferTo(file1);
                System.out.println("文件上传成功!");
                String path01 = "/static/upload/" +user.getUserId()+"/resultFile/"+fileName;
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
