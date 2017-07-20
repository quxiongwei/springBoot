package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by 屈雄伟 on 2017/7/19.
 */
@RestController
public class hellocontroller {
@GetMapping("/hello")
    public String hello(@RequestParam("id") Integer id){
    return "id:"+id;

}
}
