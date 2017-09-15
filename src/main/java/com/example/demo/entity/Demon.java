package com.example.demo.entity;

import com.sun.javafx.beans.IDProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

/**
 * 测试类
 */
@Entity
public class Demon implements Serializable {
    @javax.persistence.Id
    @GeneratedValue
    private long id;
    private String name;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
