package com.example.demo.handle;

import com.example.demo.Util.ResultUtil;
import com.example.demo.entity.Result;
import com.example.demo.exception.ExceptionMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 这个类是用户对异常的处理，让它只返回我们需要的属性
 * Created by 屈雄伟 on 2017/7/21.
 */

@ControllerAdvice
public class ExceptionHandle{
    private final  static Logger logger =LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
   @ResponseBody
    public Result handle( Exception e){
        if (e instanceof ExceptionMsg){
            ExceptionMsg exception =(ExceptionMsg) e;
            return  ResultUtil.message(exception.getCode(),exception.getMessage());
        }else {
            logger.error("[系统异常]{}",e);
            return ResultUtil.message(-1, e .getMessage());
        }
    }
}
