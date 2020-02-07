package com.suruomo.material.controller;

import com.suruomo.material.dao.UserMapper;
import com.suruomo.material.pojo.User;
import com.suruomo.material.utils.GetIp;
import com.suruomo.material.utils.Md5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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

}
