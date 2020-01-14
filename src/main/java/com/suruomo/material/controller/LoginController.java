package com.suruomo.material.controller;

import java.util.UUID;

import com.suruomo.material.dao.UserMapper;
import com.suruomo.material.pojo.User;
import com.suruomo.material.utils.Md5;
import com.suruomo.material.utils.VerifyCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author 苏若墨
 */
@Controller
public class LoginController {
    @Resource
    private UserMapper userMapper;
    /**
     * 验证码
     */
    public static final String verifyCode="verifyCode";

    @GetMapping(value = {"/","index"})
    public String hello() {
        return "login";
    }

    @GetMapping("/verifycode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        // 设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        // 不缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        try {
            HttpSession session = request.getSession();
            VerifyCode tool = new VerifyCode();
            StringBuffer code = new StringBuffer();
            BufferedImage image = tool.genRandomCodeImage(code);
            session.removeAttribute(verifyCode);
            session.setAttribute(verifyCode, code.toString());
            // 将内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @PostMapping(value = {"/doLogin"})
    public String doLogin(@RequestParam("username") String userId, @RequestParam("password") String password,
                          @RequestParam("verifycode") String verifycode,
                          HttpServletRequest request, HttpServletResponse response, Model model) {
        //校验验证码
        //session中的验证
        String sessionCaptcha = (String) SecurityUtils.getSubject().getSession().getAttribute(verifyCode);
        System.out.println("验证码是："+sessionCaptcha);
        if (null == verifycode || !verifycode.equalsIgnoreCase(sessionCaptcha)) {
            model.addAttribute("msg","验证码错误！");
            return "login";
        }

        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject= SecurityUtils.getSubject();
        //2.获取MD5加密后密码，封装用户数据
        password= new Md5().endode(password);
        boolean rm=true;
        if(request.getParameter("rememberMe")==null){
            rm=false;
        }
        UsernamePasswordToken token=new UsernamePasswordToken(userId,password,rm);
        try{
            //若当前用户没有授权，进行验证
            if(!subject.isAuthenticated()){
                subject.login(token);
            }
        } catch (UnknownAccountException e) {
            //登陆失败：用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }
        catch(IncorrectCredentialsException e){
            //登陆失败：密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
        catch(LockedAccountException e){
            //登陆失败：账户被锁定
            model.addAttribute("msg","该账号已锁定，请联系管理员后登陆");
            return "login";
        }
        // 通过用户名到数据库查询用户信息
        User user = userMapper.selectByPrimaryKey(userId);
        //UUID生成当前唯一标识符
        String userToken = UUID.randomUUID().toString();
        user.setToken(userToken);
        //将用户信息写入数据库
        userMapper.updateByPrimaryKey(user);
        Cookie cookie = new Cookie("token", userToken);
        // 设置cookie的过期时间，单位为秒，这里为一天
        cookie.setMaxAge(86400);
        response.addCookie(cookie);
        return "redirect:/main";
    }
    @GetMapping(value = {"/main"})
    public String index(HttpServletRequest request,Model model) {
        //拿到cookies数组
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                for(Cookie cookie1:cookies){
                    if(cookie1.getName().equals("rememberMe")) {
                        String token=cookie.getValue();
                        //根据cookie去数据库拿到user对象
                        User user=userMapper.findByToken(token);
                        //当token和rememberMe都存在时说明处于登录状态
                        if(user!=null){
                            request.getSession().setAttribute("user",user);
                        }
                        break;
                    }
                }
                break;
            }
        }
        return "main";
    }

    @GetMapping(value = {"/user/exit"})
    public String doLogout(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        request.getSession().invalidate();
        return "redirect:/";
    }
}
