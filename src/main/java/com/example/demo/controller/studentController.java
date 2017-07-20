package com.example.demo.controller;

import com.example.demo.dao.studentDao;
import com.example.demo.entity.student;
import com.example.demo.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 屈雄伟 on 2017/7/19.
 */
@RestController
public class studentController {
  @Autowired
  private studentService studentService;

    /**
     * 查询列表所有学生
      * @return
     */
  @GetMapping("/student")
    public List<student>serchStudent(){
       student student = new student();

       return studentService.serchStudent();
    }

    /**
     * 根据id查询某个学生
     * @param id
     * @return
     */
    @GetMapping("/findByStudent")
    public student findByStudent(@RequestParam("id")Integer id){
        System.out.println("id = [" + id + "]");
        return studentService.findByStudent(id);
    }

    /**
     * 新增学生
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/saveStudent")
    public student saveStudent(@RequestParam("name")String name,@RequestParam("age")String age){
       /* student student = new student();
        student.setAge(age);
        student.setName(name);*/

        return studentService.saveStudent(name,age);
    }

    /**
     *
     * 更新一个学生
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping ("/updateStudent")
    public student updateStudent(@RequestParam("id")Integer id,@RequestParam("name")String name,@RequestParam("age")String age){


        return studentService.updateStudent(id,name,age);
    }

    /**
     * 删除一个学生
     * @param id
     */
    @DeleteMapping("/deleteSutent")
    public void deleteSutent(@RequestParam("id")Integer id){
studentService.deleteStudent(id);
    }

    /**
     * 已添加对象的方式进行添加一个学生
      */
    @PostMapping("/student")
    public student saveStudent(student student){
        return studentService.saveStudent(student);
}

}
