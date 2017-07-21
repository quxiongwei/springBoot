package com.example.demo.Util;

import com.example.demo.entity.Result;

/**
 * Created by 屈雄伟 on 2017/7/21.
 */
public class ResultUtil {

    /**
     * 请求成功以后返回的对象
     * @param object
     * @return
     */
 public static Result success(Object object){
     Result result = new Result();
     result.setCode(0);
     result.setMes("成功");
     result.setData(object);
     return result;
 }


 public  static  Result success(){
     return  success(null);
 }
    /**
     * 请求失败以后返回的对象
     * @param code
     * @param Mes
     * @return
     */
 public  static  Result message(Integer code ,String Mes){
     Result result = new Result();
     result.setCode(code);
     result.setMes(Mes);
     return result;
 }


}
