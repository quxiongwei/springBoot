package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by 屈雄伟 on 2017/7/19.
 */
@Entity
public class student {
    @Id
    @GeneratedValue
    private Integer id;
    private  String name;
    @Min(value=18,message = "未成年学生应该继续学习，不允许贪玩")
    private  Integer age;
    @NotNull(message = "money不能为null")
    private  String money;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
