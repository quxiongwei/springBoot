package com.example.demo.config;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

public class MyShiroRealm extends AuthenticatingRealm {
@Autowired
private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("进来了");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.findByUsername(username);
        System.out.println("----->>user="+user);
        if(user == null){
            return null;
        }


       /* System.out.println("token = [" + token.hashCode() + "]");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
          String username=usernamePasswordToken.getUsername();
        String password = String.valueOf(usernamePasswordToken.getPassword());
        List<User> users = userService.serchUser();
        for (int i = 0; i <users.size() ; i++) {
            String username1 = users.get(i).getUsername();
            if (username1.equals(username)){
                 a=true;
            }
        }
        if (a==false){
            throw  new UnknownAccountException("用户不存在");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo( username, password ,getName());
        return info;*/
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                        user, //用户名
                        user.getPassword(), //密码
                        ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt*/
                        getName()  //realm name
                );
    return authenticationInfo ;
    }


}
