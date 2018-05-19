package com.lmm.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lmm on 2018/4/23.
 */
@Aspect
@Component
public class HttpAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.lmm.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();
        //url
        logger.info("url={}", httpServletRequest.getRequestURL());

        //method
        logger.info("method={}", httpServletRequest.getMethod());

        //ip(ipv6:0:0:0:0:0:0:0:1  ipv4:127.0.0.1)
        logger.info("ip={}", httpServletRequest.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("aspect after...");
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfterReturning(Object object){
        logger.info("response={}", JSONObject.toJSON(object));
    }
}
