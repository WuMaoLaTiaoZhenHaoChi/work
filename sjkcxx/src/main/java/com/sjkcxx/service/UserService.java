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

    /**
     * 用户列表
     * @param pageDto:分页条件
     * @return：用户分页数据集合
     */
    PageDto<UserInfo> listUser(PageDto pageDto);

    /**
     * 移除用户
     * @param userNum:用户账号
     * @return  成功表示 0：失败，1：成功
     */
    int removeUser(String userNum);

    /**
     * 用户信息修改
     * @param userInfo：用户信息
     * @return  成功表示 0：失败，1：成功
     */
    int editUser(UserInfo userInfo);

    /**
     * 用户注册
     * @param userInfo：用户信息
     * @return 成功表示 0：失败，1：成功
     */
    int registerUser(UserInfo userInfo);
}
