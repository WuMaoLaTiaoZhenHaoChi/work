package com.sjkcxx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: duant
 * @Date: 2020/2/27 17:26
 */
@Controller
@RequestMapping("/test")
public class TestBean {

    @RequestMapping("/1")
    public String test1(){
        return "index";
    }

}
