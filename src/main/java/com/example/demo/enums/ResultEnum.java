package com.example.demo.enums;

/**
 * 管理异常错的类
 * Created by 屈雄伟 on 2017/7/21.
 */
public enum ResultEnum {
            SUSSER(0,"成功"),
            ERROR(-1,"失败"),
           RESULT_STUDENT_SCHOOL(100,"你可能还在上小学"),
           MIDDLE_STUDENT_SCHOOL(101,"你可能还在上中学"),
           IDDLE_STUDENT_SCHOOL(102,"你可能还在上高学"),
           IDDLE_STUDENT_MAXSCHOOL(103,"你可能还在上大学"),
    ;
    private  Integer code;
    private  String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
