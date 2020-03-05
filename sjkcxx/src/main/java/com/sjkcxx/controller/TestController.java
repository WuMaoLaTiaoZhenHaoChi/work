package com.sjkcxx.controller;

import com.sjkcxx.entity.Student;
import com.sjkcxx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/1 10:43
 * @Description:
 */
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/getList")
    public List<Student> getList(){
        System.out.println("getList");
        List<Student> list = studentService.list();
        System.out.println(list);
        return list;
    }

    @GetMapping("/test1")
    public String test1(){
        System.out.println("请求 test1");
        return "login.html";
    }

}
