package com.sjkcxx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjkcxx.entity.StudentSubject;
import com.sjkcxx.mapper.StudentSubjectMapper;
import com.sjkcxx.service.StudentSubjectService;
import org.springframework.stereotype.Service;

/**
 * @Author: duant
 * @Date: 2020/3/7 15:15
 * @Description:
 */
@Service
public class StudentSubjectServiceImpl extends ServiceImpl<StudentSubjectMapper, StudentSubject> implements StudentSubjectService {
}
