package com.example.demo.controller;

import com.example.demo.entity.Demon;
import com.example.demo.service.DemonService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController("controller.DemonController")
//@RequestMapping(value="/data/mybatis/author")
@Controller
@RequestMapping("/demon")
@MapperScan("com.example.demo.dao.DemonDao")
public class DemonController {
@Autowired
    private DemonService demonService;
@RequestMapping("/likename")
    public List<Demon>likename(@RequestParam("name")String name){
        return demonService.likeName(name);
}

}
