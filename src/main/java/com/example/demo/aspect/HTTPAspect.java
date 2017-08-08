package com.example.demo.aspect;


import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.net.URL;

import static javax.print.attribute.standard.ReferenceUriSchemesSupported.HTTP;


/**
 * Created by 屈雄伟 on 2017/7/20.
 */
@Aspect
@Component
public class HTTPAspect {
    private static final Logger Logger= LoggerFactory.getLogger(HTTPAspect.class);

    /**
     * 这个方法里面主要是设定了aop 的 切面编程 获取controller 里面的方法执行的log记录
     */

    @Pointcut("execution(public * com.example.demo.controller..*(..))")
    public void log(){
    }

    /**
     * 方法执行前 就前执行这个方法 输出log
     * @param joinPoint
     */
    @Before("log()")
    public void beforeLog(JoinPoint joinPoint){
        ServletRequestAttributes ServletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ServletRequestAttributes.getRequest();
       //url
        Logger.info("URL={}",request.getRequestURI());
        //menthod
        Logger.info("menthod={}",request.getMethod());
       //ip
        Logger.info("ip={}",request.getRemoteAddr());
        //类方法
        Logger.info("class_menthod={}",joinPoint.getSignature().getDeclaringTypeName()+"."+ joinPoint.getSignature().getName());
        //参数
        Logger.info("arg={}",joinPoint.getArgs());
    }
    @After("log()")
    public void  afterLog(){

    }

    /**
     * 返回数据的内容 ，返回内容可能会有很多种，所以我这边设置了object
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void afterReturing(Object object){
   Logger.info("reponse={}",object.toString());
    }

}
