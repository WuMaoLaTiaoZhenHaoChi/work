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
     * 上传作业
     * @param studentSubject：学生成绩信息
     * @return：成功标识符 0：失败，1：成功
     */
    int studentUpload(StudentSubject studentSubject);

    /**
     * 教师打分
     * @param studentSubject：学生成绩信息
     * @return：成功标识符 0：失败，1：成功
     */
    int gradeToStudent(StudentSubject studentSubject);

    /**
     * 学生打分
     * @param studentSubject：学生成绩信息
     * @return：成功标识符 0：失败，1：成功
     */
    int studentScoreRate(StudentSubject studentSubject);


    /**
     * 学生课程列表展示
     * @param studentSubject：
     * @param pageDto：分页信息数据封装信息（需要展示的页码等信息）
     * @return：分页学生成绩信息数据封装信息
     */
    PageDto<StudentSubject> queryStudentSubjectLike(StudentSubject studentSubject, PageDto pageDto);

}
