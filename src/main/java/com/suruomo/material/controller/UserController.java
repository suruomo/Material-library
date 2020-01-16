package com.suruomo.material.controller;

import com.suruomo.material.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

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
        String id="2020"+userId;
        model.addAttribute("userId",id);
        return "user/register";
    }
}
