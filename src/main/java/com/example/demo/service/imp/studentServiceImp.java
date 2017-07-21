package com.example.demo.service.imp;

import com.example.demo.dao.studentDao;
import com.example.demo.entity.student;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.ExceptionMsg;
import com.example.demo.service.studentService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
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
  public student saveStudent(String name,Integer age){
       student student = new student();
       student.setName(name);
       student.setAge(age);
       return studentDao.save(student);
 }
 @Override
    public student updateStudent(Integer id,String name,Integer age){
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

    @Override
    @Transactional
    public void  insetTwoStudent() {
        student student = new student();
        student.setName("A");
        student.setAge(22);
        studentDao.save(student);

        student student1 = new student();
        student1.setName("B");
        student1.setAge(2);
        studentDao.save(student1);
    }

    /**
     * 根据一个学生的年龄判断正在上什么学
     * @param id
     * @throws Exception
     */
    public void serchStudentByid(Integer id) throws Exception {
        student student = studentDao.findOne(id);
        Integer age = student.getAge();
        if (age <= 10) {
            throw new ExceptionMsg(ResultEnum.RESULT_STUDENT_SCHOOL);
        } else if (age >= 10 && age <= 16) {
            throw new ExceptionMsg(ResultEnum.MIDDLE_STUDENT_SCHOOL);
        } else if (age > 16 && age < 20) {
            throw new ExceptionMsg(ResultEnum.IDDLE_STUDENT_SCHOOL);
        } else if (age >=20) {
            throw new ExceptionMsg(ResultEnum.IDDLE_STUDENT_MAXSCHOOL);
        }
    }
}
