package com.sjkcxx.controller;

import com.sjkcxx.base.PageDto;
import com.sjkcxx.base.ResultVo;
import com.sjkcxx.entity.UserInfo;
import com.sjkcxx.mapper.UserMapper;
import com.sjkcxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author: duant
 * @Date: 2020/4/15 21:12
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //编辑用户
    @PostMapping("/editUserPwd")
    public ResultVo editUserPwd(UserInfo userInfo,HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        user.setUserPwd(userInfo.getUserPwd());
        int i = userService.editUser(user);
        if (i > 0){
            return ResultVo.success();
        }
        return ResultVo.build("400","修改失败");
    }

    //编辑用户
    @PostMapping("/editUser")
    public ResultVo editUser(UserInfo userInfo){
        int i = userService.editUser(userInfo);
        if (i > 0){
            return ResultVo.success();
        }
        return ResultVo.build("400","修改失败");
    }

    //注册用户
    @PostMapping("/registerUser")
    public ResultVo registerUser(UserInfo userInfo){
        int i = userService.registerUser(userInfo);
        if (i > 0){
            return ResultVo.success();
        }
        return ResultVo.build("400","注册失败");
    }

    //用户列表
    @GetMapping("/listUser")
    public ResultVo listUser(UserInfo userInfo, PageDto pageDto, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        userInfo.setUserType(user.getUserType());
        PageDto<UserInfo> userInfoPageDto = userService.listUser(userInfo,pageDto);
        return ResultVo.build("0","success",userInfoPageDto);
    }


}
