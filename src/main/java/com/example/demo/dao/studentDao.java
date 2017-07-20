package com.example.demo.dao;

import com.example.demo.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 屈雄伟 on 2017/7/19.
 */
public interface studentDao extends JpaRepository<student,Integer>{
}

