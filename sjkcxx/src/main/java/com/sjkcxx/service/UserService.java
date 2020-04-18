package com.sjkcxx.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sjkcxx.base.PageDto;
import com.sjkcxx.entity.UserInfo;
import com.sjkcxx.mapper.UserMapper;

/**
 * @Author: duant
 * @Date: 2020/3/1 16:30
 * @Description:
 */
public interface UserService extends IService<UserInfo> {

    PageDto<UserInfo> listUser(PageDto pageDto);

    /**
     * 移除用户
     * @param userNum
     * @return
     */
    int removeUser(String userNum);

    /**
     * 用户信息修改
     * @param userInfo
     * @return
     */
    int editUser(UserInfo userInfo);

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    int registerUser(UserInfo userInfo);
}
