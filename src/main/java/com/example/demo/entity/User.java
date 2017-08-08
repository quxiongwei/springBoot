package com.example.demo.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by 屈雄伟 on 2017/7/24.
 */
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    private String name;//名称（昵称或者真实姓名，不同系统不同定义）
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    private String salt;//加密密码的盐

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private byte state;

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public User() {
        super();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
    @Override
    public String toString() {
        return "UserInfo [ username=" + username + ", name=" + name + ", password=" + password
                + ", salt=" + salt + ", state=" + state + "]";
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
