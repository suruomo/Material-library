package com.suruomo.material.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suruomo.material.aop.SystemLog;
import com.suruomo.material.dao.UserMapper;
import com.suruomo.material.pojo.User;
import com.suruomo.material.utils.GetIp;
import com.suruomo.material.utils.Md5;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 苏若墨
 */
@Controller
public class UserController {
    @Resource
    private UserMapper userMapper;

    @GetMapping(value = {"/register"})
    public String register(Model model) {
        long userId=userMapper.findMaxUserId()+1;
        model.addAttribute("userId",userId);
        return "user/register";
    }

    @GetMapping(value = {"/user/info"})
    public String info(HttpServletRequest request,Model model) {
        User user=(User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "user/info";
    }

    @GetMapping(value = {"/admin/user/list"})
    public String List() {
        return "admin/user/list";
    }

    @GetMapping(value = {"/user/modifypwd"})
    public String modifyPWD(Model model) {
            return "user/modifypwd";
    }

    /**
     * 增加用户信息
     * @param user
     * @param request
     * @return
     */
    @PostMapping(value ={"/user"})
    public String addUser(User user, HttpServletRequest request){
        String password=new Md5().endode(user.getPassword());
        user.setPassword(password);
        user.setLastIp(new GetIp().getIpAddr(request));
        user.setCreateBy(user.getUserName());
        user.setCreateTime(new Date());
        user.setUpdateBy(user.getUserName());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
        return "redirect:/admin/user/list";
    }

    /**
     * 修改用户信息
     * @param user
     * @param request
     * @return
     */
    @PutMapping("/user")
    public String modifyUser(User user, HttpServletRequest request){
        User oldUser=userMapper.selectByPrimaryKey(user.getUserId());
        oldUser.setLastIp(new GetIp().getIpAddr(request));
        oldUser.setUpdateBy(user.getUserName());
        oldUser.setUpdateTime(new Date());
        oldUser.setUserName(user.getUserName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhone(user.getPhone());
        oldUser.setRole(user.getRole());
        oldUser.setGender(user.getGender());
        userMapper.updateByPrimaryKey(oldUser);
        return "redirect:/admin/user/list";
    }
    @SystemLog(module = "操作：管理员修删除用户")
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") String userId) {
        userMapper.deleteByPrimaryKey(Long.parseLong(userId));
        return "success";
    }
    /**
     * 修改密码
     * @param request
     * @param oldPassword
     * @param newPassword
     * @param reNewPassword
     * @param model
     * @return
     */
    @PostMapping(value ={"/password"})
    public String modifyPassword(HttpServletRequest request,@RequestParam("oldPWD")String oldPassword,@RequestParam("newPWD")String newPassword,@RequestParam("reNewPWD")String reNewPassword
                                 ,Model model){
        System.out.println("旧密码："+oldPassword);
        System.out.println("新密码："+newPassword);
        String old=new Md5().endode(oldPassword);
        String newPws=new Md5().endode(newPassword);
        System.out.println("新加密"+newPws);
        User user=(User) request.getSession().getAttribute("user");
        if(!user.getPassword().equals(old)){
            model.addAttribute("msg","旧密码输入错误，请重新输入！");
        }
        else{
            user.setPassword(newPws);
            user.setUpdateTime(new Date());
            System.out.println(new Date());
            user.setUpdateBy(user.getUserName());
            userMapper.updateByPrimaryKey(user);
        }
        return "redirect:/main";
    }

    /**
     * 返回用户列表数据
     * @param page
     * @param limit
     * @return
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping(value = "/usersData")
    public Map<String, Object> users(@RequestParam("page") int page, @RequestParam("limit") int limit) throws JsonProcessingException {
        System.out.println("page"+page+","+"limit"+limit);
        int start=(page-1)*limit+1;
        int end =page*limit;
        List<User> users = userMapper.getAll(start, end);
        int count = userMapper.getCount();
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
     * 跳转增加用户界面
     * @return
     */
    @GetMapping("/user")
    public String toAddPage(Model model) {
        long userId=userMapper.findMaxUserId()+1;
        model.addAttribute("newId",userId);
        return "admin/user/add";
    }

    /**
     * 跳转修改用户界面
     * @param userId
     * @param model
     * @return
     */
    @GetMapping("/user/{id}")
    public String toEditPage(@PathVariable("id") String userId, Model model) {
        User user = userMapper.selectByPrimaryKey(Long.parseLong(userId));
        model.addAttribute("user", user);
        System.out.println(user);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "admin/user/add";
    }

    /**
     * 重置用户密码：重置后为用户ID
     * @param userId
     * @return 成功返回1，否则返回2
     */
    @SystemLog(module = "操作：管理员重置用户密码")
    @PostMapping("/reset/{id}")
    @ResponseBody
    public String resetPassword(@PathVariable("id") String userId) {
        User user=userMapper.selectByPrimaryKey(Long.parseLong(userId));
        try {
            user.setPassword(new Md5().endode(userId));
            userMapper.updateByPrimaryKey(user);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "2";
        }
    }
}
