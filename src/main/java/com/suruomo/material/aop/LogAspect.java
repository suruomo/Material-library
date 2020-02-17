package com.suruomo.material.aop;

import com.suruomo.material.dao.LogMapper;
import com.suruomo.material.pojo.Log;
import com.suruomo.material.pojo.User;
import com.suruomo.material.utils.GetIp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 切面类
 *
 * @author 苏若墨
 */
@Aspect
@Component
public class LogAspect {
    @Resource
    private LogMapper logMapper;
    private GetIp getIp = new GetIp();

    @Pointcut("@annotation(com.suruomo.material.aop.SystemLog)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        //模块开始时间
        long start = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log sysLog = new Log();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        // 设置请求的方法名
        sysLog.setRequestMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += "  " + paramNames[i] + ": " + args[i];
            }
            // 设置请求的方法参数名称
            sysLog.setParameter(params);
        }
        // 获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 设置IP地址
        sysLog.setIp(getIp.getIpAddr(request));
        // 获取用户
        User user = (User) request.getSession().getAttribute("user");
        sysLog.setUserName(user.getUserName());
        sysLog.setUserId(new BigDecimal(user.getUserId()));
        //获取系统时间
//        String date = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
        sysLog.setRequestDate(new Date());
        int id=logMapper.getMaxId()+1;
        SystemLog logAnnotation = method.getAnnotation(SystemLog.class);
        if (logAnnotation != null) {
            // 注解上的描述
            try {
                sysLog.setRequestModule(logAnnotation.module());
                result = joinPoint.proceed();
                long end = System.currentTimeMillis();
                //将计算好的时间保存在实体中
                sysLog.setResponseTime("" + (end - start));
                sysLog.setStatus("执行成功");
                sysLog.setId(new BigDecimal(id++));
                //保存进数据库
                logMapper.insert(sysLog);
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                sysLog.setRequestModule(logAnnotation.module());
                long end = System.currentTimeMillis();
                sysLog.setResponseTime("" + (end - start));
                sysLog.setStatus("执行失败");
                sysLog.setId(new BigDecimal(id++));
                //保存进数据库
                logMapper.insert(sysLog);
            }
        }
        return result;
    }
}