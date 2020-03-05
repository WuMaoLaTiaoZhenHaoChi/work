package com.sjkcxx.controller;

import com.sjkcxx.entity.Student;
import com.sjkcxx.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: duant
 * @Date: 2020/2/29 10:45
 * @Description:
 */
@Controller
public class LoginController {

    /**
     * 主页
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }



}
