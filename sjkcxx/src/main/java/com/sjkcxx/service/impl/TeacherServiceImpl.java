package com.sjkcxx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjkcxx.entity.TeacherInfo;
import com.sjkcxx.mapper.TeacherMapper;
import com.sjkcxx.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * @Author: duant
 * @Date: 2020/3/7 15:12
 * @Description:
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, TeacherInfo> implements TeacherService {
}
