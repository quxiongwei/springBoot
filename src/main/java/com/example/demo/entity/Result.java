package com.example.demo.entity;

/**
 * HTTP请求返回的最外层对象
 * Created by 屈雄伟 on 2017/7/21.
 */
public class Result<T> {
    private  Integer code;
    private  String mes;
    private  T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
