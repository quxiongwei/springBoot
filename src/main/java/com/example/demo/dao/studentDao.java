package com.example.demo.dao;

import com.example.demo.entity.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by 屈雄伟 on 2017/7/19.
 */
@Repository
public interface studentDao extends JpaRepository<student,Integer>{

}

