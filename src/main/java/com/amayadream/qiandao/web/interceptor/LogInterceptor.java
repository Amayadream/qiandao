package com.amayadream.qiandao.web.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志切面, 负责拦截请求记录日志, 优先级最低
 * @author :  Amayadream
 * @date :  2017.03.15 17:10
 */
@Order(2)
@Aspect
@Component
public class LogInterceptor {

    private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    /**
     * 用户登陆日志
     */
    @AfterReturning(value = "execution(public * com.amayadream.qiandao.web.controller.AuthController.login(..))")
    public void auth(JoinPoint point){
        Object[] objects = point.getArgs();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }


}
