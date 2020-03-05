package com.sjkcxx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjkcxx.entity.UserInfo;
import com.sjkcxx.mapper.UserMapper;
import com.sjkcxx.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.management.remote.rmi.RMIServerImpl;

/**
 * @Author: duant
 * @Date: 2020/3/1 16:30
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {

}
