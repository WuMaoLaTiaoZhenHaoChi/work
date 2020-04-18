package com.sjkcxx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjkcxx.base.PageDto;
import com.sjkcxx.entity.PracticeSubject;
import com.sjkcxx.entity.StudentSubject;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/7 15:08
 * @Description:实践课程service
 */
public interface PracticeSubjectService extends IService<PracticeSubject> {

    /**
     * 审核课程
     * @param practiceSubject
     * @return
     */
    int adminCheckSubject(PracticeSubject practiceSubject);

    /**
     * 学生选课
     * @param practiceSubject
     * @param studentSubject
     * @return
     */
    int studentSelectSubject(PracticeSubject practiceSubject, StudentSubject studentSubject);

    /**
     * 学生多条件查询已审核学科信息
     * @param practiceSubject
     * @return
     */
    PageDto<PracticeSubject> studentQuerySubjectLike(PracticeSubject practiceSubject, PageDto pageDto);

    /**
     * 多条件查询学科信息
     * @param practiceSubject
     * @return
     */
    PageDto<PracticeSubject> querySubjectLike(PracticeSubject practiceSubject, PageDto pageDto);

}
