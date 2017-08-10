package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.handle.ExceptionHandle;
import com.example.demo.service.UserService;
import com.mysema.commons.lang.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by 屈雄伟 on 2017/7/24.
 */
@Controller
public class Usercontroller {
    private static Logger logger= LoggerFactory.getLogger(Usercontroller.class);
    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){
        return"/login";
    }
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");

        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }

        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "/login";
    }

 /*   @PostMapping(value = "/submitLogin")
    @ResponseBody
    public Map<String,Object> submitLogin(@RequestParam("username") String username ,@RequestParam("password") String password ){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(token);
            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");

        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", e.getMessage());
        }
        return  resultMap;
    }
*/

    @RequestMapping("/userInfo")
    public String  userInfo(){
        return  "/userInfo";
    }
    @RequestMapping("/userInfoAdd")
    public String  userInfoAdd(){
        return  "/userInfoAdd";
    }
    @RequestMapping("/userInfoDel")
    public String  userInfoDel(){
        return  "/userInfoDel";
    }




   /* public String login(@RequestParam("username")String username,@RequestParam("password")String password) {
        Subject currenuser = SecurityUtils.getSubject();
    if(!currenuser.isAuthenticated()){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
     token.setRememberMe(true);
    try {
        //执行登录
        System.out.println("1token="+ token.hashCode() +"");
       currenuser.login(token);
    }catch (AuthenticationException e){
        logger.error("登录失败",e.getMessage());
    }
    }
        currenuser.logout();
        return "/userInfo";
    }*/
    /*@GetMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }*/

   /* public List<User> denglu(@RequestParam("usernname")String username ,@RequestParam("password")String password){
         return  userService.serchUser();
    }*/

   @RequestMapping("/logout")
   public String logout(){
       return "logout";
   }
  @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

}
