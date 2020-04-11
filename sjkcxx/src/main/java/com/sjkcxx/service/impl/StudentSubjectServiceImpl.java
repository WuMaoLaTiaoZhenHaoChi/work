package com.sjkcxx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjkcxx.base.PageDto;
import com.sjkcxx.entity.StudentSubject;
import com.sjkcxx.mapper.StudentSubjectMapper;
import com.sjkcxx.service.StudentSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/7 15:15
 * @Description:
 */
@Service
public class StudentSubjectServiceImpl extends ServiceImpl<StudentSubjectMapper, StudentSubject> implements StudentSubjectService {

    @Autowired
    private StudentSubjectMapper studentSubjectMapper;

    //学生打分
    @Override
    public int studentScoreRate(StudentSubject studentSubject) {
        int i = -1;
        String studentSubjectNum = studentSubject.getStudentSubjectNum();
        if (studentSubjectNum == null || studentSubjectNum.equals("")){
            return i;
        }
        StudentSubject studentSubjectTemp = studentSubjectMapper.selectById(studentSubjectNum);
        studentSubjectTemp.setSubjectScore(studentSubject.getSubjectScore());
        studentSubjectTemp.setSubjectRemark(studentSubject.getSubjectRemark());
        i = studentSubjectMapper.updateById(studentSubjectTemp);
        return i;
    }

    //学生课程列表
    @Override
    public PageDto<StudentSubject> queryStudentSubjectLike(StudentSubject studentSubject, PageDto pageDto) {
        pageDto.calculateCurrent();
        List<StudentSubject> studentSubjects = studentSubjectMapper.selectStudentSubjectBySS(studentSubject, pageDto);
        int count = studentSubjectMapper.countStudentSubjectBySS(studentSubject);
        pageDto.setPageDto(count,studentSubjects);
        return pageDto;
    }

}
