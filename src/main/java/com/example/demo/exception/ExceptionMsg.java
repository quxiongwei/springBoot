package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

/**
 * Created by 屈雄伟 on 2017/7/21.
 */
public class ExceptionMsg extends RuntimeException{
    private  Integer code;


    public ExceptionMsg(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
