package com.example.demo.dao;

import com.example.demo.entity.Demon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface DemonDao {
     @Select("select * from  demon where name=#{name}")
     List<Demon> likeName(String name);

}
