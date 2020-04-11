package com.sjkcxx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjkcxx.base.PageDto;
import com.sjkcxx.entity.PracticeSubject;
import com.sjkcxx.entity.StudentSubject;
import com.sjkcxx.mapper.StudentSubjectMapper;

/**
 * @Author: duant
 * @Date: 2020/3/7 15:14
 * @Description:
 */
public interface StudentSubjectService extends IService<StudentSubject> {

    /**
     * 学生打分
     * @param studentSubject
     * @return
     */
    int studentScoreRate(StudentSubject studentSubject);


    /**
     * 学生课程列表展示
     * @param studentSubject
     * @param pageDto
     * @return
     */
    PageDto<StudentSubject> queryStudentSubjectLike(StudentSubject studentSubject, PageDto pageDto);

}
