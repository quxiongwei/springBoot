package com.example.demo.service.imp;

import com.example.demo.dao.studentDao;
import com.example.demo.entity.student;
import com.example.demo.service.studentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 屈雄伟 on 2017/7/19.
 */
@Service
public class studentServiceImp implements studentService {
    @Resource
    private studentDao studentDao;
    @Override
    public List<student> serchStudent() {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return studentDao.findAll();
    }

    @Override
    public student findByStudent(Integer id){
    return studentDao.findOne(id);
    }
   @Override
  public student saveStudent(String name,String age){
       student student = new student();
       student.setName(name);
       student.setAge(age);
       return studentDao.save(student);
 }
 @Override
    public student updateStudent(Integer id,String name,String age){
     student student = new student();
     student.setId(id);
     student.setName(name);
     student.setAge(age);
     return studentDao.save(student);
 }

    @Override
    public void deleteStudent(Integer id) {
        studentDao.delete(id);
    }

    @Override
    public student saveStudent(student student) {
        student.setAge(student.getAge());
        student.setName(student.getName());
        return studentDao.save(student);
    }


}
