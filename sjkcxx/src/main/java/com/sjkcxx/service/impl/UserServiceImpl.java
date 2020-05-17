package com.sjkcxx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjkcxx.base.PageDto;
import com.sjkcxx.entity.StudentInfo;
import com.sjkcxx.entity.TeacherInfo;
import com.sjkcxx.entity.UserExcelInfo;
import com.sjkcxx.entity.UserInfo;
import com.sjkcxx.mapper.StudentMapper;
import com.sjkcxx.mapper.TeacherMapper;
import com.sjkcxx.mapper.UserMapper;
import com.sjkcxx.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.remote.rmi.RMIServerImpl;
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
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Transactional
    @Override
    public int addExcelUser(UserExcelInfo userExcelInfo) {
        String userNum = userExcelInfo.getUserNum();
        String userName = userExcelInfo.getUserName();
        String userType = userExcelInfo.getUserType();
        UserInfo byId = userMapper.selectById(userNum);
        if (byId != null){
            return -1;
        }
        UserInfo userInfo = userExcelInfo.getUserInfo();
        int userI = userMapper.insert(userInfo);
        int i = 0;
        if (userType.equals("0")){
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setUserNum(userNum);
            studentInfo.setUserName(userName);
            i = studentMapper.insert(studentInfo);
        } else if (userType.equals("1")){
            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setUserNum(userNum);
            teacherInfo.setUserName(userName);
            i  = teacherMapper.insert(teacherInfo);
        } else {
            return 1;
        }
        return userI & i;
    }

    //用户列表
    @Override
    public PageDto<UserInfo> listUser(UserInfo userInfo,PageDto pageDto) {
        pageDto.calculateCurrent();
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
            i = studentMapper.deleteById(userNum);
        }else if (userType.equals("1")){
            i = teacherMapper.deleteById(userNum);
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
            StudentInfo studentInfo = studentMapper.selectById(userNum);
            studentInfo.setUserName(userName);
            studentInfo.setUserName(userName);
            i = studentMapper.updateById(studentInfo);
        } else if (userType.equals("1")){
            TeacherInfo teacherInfo = teacherMapper.selectById(userNum);
            teacherInfo.setUserName(userName);
            teacherInfo.setUserName(userName);
            i  = teacherMapper.updateById(teacherInfo);
        } else {
            return 1;
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
        UserInfo byId = userMapper.selectById(userNum);
        if (byId != null){
            return -1;
        }
        int userI = userMapper.insert(userInfo);
        int i = 0;
        if (userType.equals("0")){
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setUserNum(userNum);
            studentInfo.setUserName(userName);
            i = studentMapper.insert(studentInfo);
        } else if (userType.equals("1")){
            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setUserNum(userNum);
            teacherInfo.setUserName(userName);
            i  = teacherMapper.insert(teacherInfo);
        }else {
            return 1;
        }
        return userI & i;
    }

}
