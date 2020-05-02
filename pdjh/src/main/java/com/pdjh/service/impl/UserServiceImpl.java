package com.pdjh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.pdjh.base.PageDto;
import com.pdjh.entity.CustomerInfo;
import com.pdjh.entity.EmployeeInfo;
import com.pdjh.entity.UserInfo;
import com.pdjh.mapper.CustomerMapper;
import com.pdjh.mapper.EmployeeMapper;
import com.pdjh.mapper.OrderMapper;
import com.pdjh.mapper.UserMapper;
import com.pdjh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/1 16:30
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmployeeMapper EmployeeMapper;

    @Autowired
    private CustomerMapper CustomerMapper;

    @Autowired
    private OrderMapper orderMapper;

    //用户列表
    @Override
    public PageDto<UserInfo> listUser(UserInfo userInfo,PageDto pageDto) {
        pageDto.calculateCurrent();
//        List<UserInfo> list = list();
        List<UserInfo> list = userMapper.selectUserList(userInfo,pageDto);
        int count = list.size();
        pageDto.setData(list);
        pageDto.setCount(count);
        return pageDto;
    }

    //删除用户
    @Transactional
    @Override
    public int removeUser(String userNum) {
        UserInfo userInfo = userMapper.selectById(userNum);
        String userType = userInfo.getUserType();
        int i = 0;
        if (userType.equals("0")){
            i = CustomerMapper.deleteById(userNum);
        }else if (userType.equals("1")){
            i = EmployeeMapper.deleteById(userNum);
        }
        int userI = userMapper.deleteById(userNum);
        return i & userI;
    }

    //修改用户
    @Transactional
    @Override
    public int editUser(UserInfo userInfo) {
        String userNum = userInfo.getUserNum();
        String userName = userInfo.getUserName();
        String userType = userInfo.getUserType();
        int userI = userMapper.updateById(userInfo);
        int i = 0;
        if (userType.equals("0")){
            CustomerInfo CustomerInfo = CustomerMapper.selectById(userNum);
            CustomerInfo.setUserName(userName);
            CustomerInfo.setCustomerLevel(userInfo.getCustomerLevel());
            i = CustomerMapper.updateById(CustomerInfo);
            int customerLeave = orderMapper.updataOrderCustomerLeave(userInfo);
        } else if (userType.equals("1")){
            EmployeeInfo EmployeeInfo = EmployeeMapper.selectById(userNum);
            EmployeeInfo.setUserName(userName);
            i  = EmployeeMapper.updateById(EmployeeInfo);
        }
        return userI & i;
    }

    //添加用户
    @Transactional
    @Override
    public int registerUser(UserInfo userInfo) {
        String userNum = userInfo.getUserNum();
        String userName = userInfo.getUserName();
        String userType = userInfo.getUserType();
        int userI = userMapper.insert(userInfo);
        int i = 0;
        if (userType.equals("0")){
            CustomerInfo CustomerInfo = new CustomerInfo();
            CustomerInfo.setUserNum(userNum);
            CustomerInfo.setUserName(userName);
            i = CustomerMapper.insert(CustomerInfo);
        } else if (userType.equals("1")){
            EmployeeInfo EmployeeInfo = new EmployeeInfo();
            EmployeeInfo.setUserNum(userNum);
            EmployeeInfo.setUserName(userName);
            i  = EmployeeMapper.insert(EmployeeInfo);
        }
        return userI & i;
    }

}
