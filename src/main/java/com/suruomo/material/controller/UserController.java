package com.suruomo.material.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suruomo.material.dao.UserMapper;
import com.suruomo.material.pojo.User;
import com.suruomo.material.utils.GetIp;
import com.suruomo.material.utils.Md5;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping(value ={"/user"})
    public String addUser(User user, HttpServletRequest request){
        System.out.println(user.toString());
        String password=new Md5().endode(user.getPassword());
        user.setPassword(password);
        user.setLastIp(new GetIp().getIpAddr(request));
        user.setCreateBy(user.getUserName());
        user.setCreateTime(new Date());
        user.setUpdateBy(user.getUserName());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
        return "login";
    }
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
}
