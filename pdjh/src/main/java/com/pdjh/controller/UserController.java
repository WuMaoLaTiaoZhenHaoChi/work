package com.pdjh.controller;

import com.pdjh.base.PageDto;
import com.pdjh.base.ResultVo;
import com.pdjh.entity.UserInfo;
import com.pdjh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: duant
 * @Date: 2020/4/18 9:57
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/editUser")
    public ResultVo editUser(UserInfo userInfo){
        int i = userService.editUser(userInfo);
        if (i > 0){
            return ResultVo.success();
        }
        return ResultVo.build("400","注册失败");
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
    public ResultVo listUser(PageDto pageDto){
        PageDto<UserInfo> userInfoPageDto = userService.listUser(pageDto);
        return ResultVo.build("0","success",userInfoPageDto);
    }

}

