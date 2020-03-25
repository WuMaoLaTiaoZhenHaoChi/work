package com.pdjh.controller;

import com.pdjh.base.ResultVo;
import com.pdjh.entity.UserInfo;
import com.pdjh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: duant
 * @Date: 2020/3/1 17:10
 * @Description:
 */
@RestController
@RequestMapping("/sys")
public class SystemController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResultVo verifyLogin(UserInfo userInfo, HttpServletRequest request){
        System.out.println( "userinfo:" + userInfo);
        UserInfo user = userService.getById(userInfo.getUserNum());
        System.out.println( "user" + user);
        if (user != null && user.getUserPwd().equals(userInfo.getUserPwd()) && user.getUserType().equals(userInfo.getUserType())){
            request.getSession().setAttribute("user",user);
            return ResultVo.success(user);
        }
        return ResultVo.build("400","用户无效或密码错误！");
    }

}
