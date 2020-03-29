package com.sjkcxx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjkcxx.entity.StudentInfo;
import com.sjkcxx.mapper.StudentMapper;
import com.sjkcxx.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @Author: duant
 * @Date: 2020/3/1 10:40
 * @Description:
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentInfo> implements StudentService {

}
