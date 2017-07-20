package com.example.demo.service;

import com.example.demo.dao.studentDao;
import com.example.demo.entity.student;

import java.util.List;

/**
 * Created by 屈雄伟 on 2017/7/19.
 */
public interface studentService {

    List<student> serchStudent();
    student findByStudent(Integer id);
   student saveStudent(String name ,String age);
   student updateStudent(Integer id,String name,String age);
   void deleteStudent(Integer id);
   student saveStudent(student student);
   void insetTwoStudent();
}
