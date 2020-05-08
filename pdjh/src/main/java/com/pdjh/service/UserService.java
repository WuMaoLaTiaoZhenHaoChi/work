package com.pdjh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pdjh.base.PageDto;
import com.pdjh.entity.UserInfo;

/**
 * @Author: duant
 * @Date: 2020/3/1 16:30
 * @Description:用户操作
 */
public interface UserService extends IService<UserInfo> {

    PageDto<UserInfo> listUser(UserInfo userInfo,PageDto pageDto);

    /**
     * 修改密码
     * @param userInfo
     * @return
     */
    int edituserPwd(UserInfo userInfo);

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
