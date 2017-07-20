package com.example.demo.entity;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

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
    private  String age;


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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
