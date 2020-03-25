package com.pdjh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.pdjh.entity.UserInfo;
import com.pdjh.mapper.UserMapper;
import com.pdjh.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: duant
 * @Date: 2020/3/1 16:30
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {

}
