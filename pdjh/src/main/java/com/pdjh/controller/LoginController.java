package com.pdjh.controller;

import com.pdjh.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: duant
 * @Date: 2020/2/29 10:45
 * @Description:
 */
@Controller
public class LoginController {

    /**
     * 转发首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        String userType = user.getUserType();
        if (userType.equals("0")){
            return "index_student";
        }else if (userType.equals("1")){
            return "index_teacher";
        }else if (userType.equals("2")){
            return "index_admin";
        }
        return "index";
    }



}
