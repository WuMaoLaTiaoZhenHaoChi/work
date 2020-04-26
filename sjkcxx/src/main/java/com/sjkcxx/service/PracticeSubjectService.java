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
     * @param practiceSubject：学科信息
     * @return：成功标识符 0：失败，1：成功
     */
    int adminCheckSubject(PracticeSubject practiceSubject);
    /**
     * 学生选课
     * @param practiceSubject：学科信息
     * @param studentSubject：学生成绩信息
     * @return：成功标识符 0：失败，1：成功
     */
    int studentSelectSubject(PracticeSubject practiceSubject, StudentSubject studentSubject);
    /**
     * 学生多条件查询已审核学科信息
     * @param practiceSubject：学科信息
     * @param pageDto：分页信息数据封装信息（需要展示的页码等信息）
     * @return：分页封装数据信息
     */
    PageDto<PracticeSubject> studentQuerySubjectLike(PracticeSubject practiceSubject, PageDto pageDto);
    /**
     * 多条件查询学科信息
     * @param practiceSubject：学科信息
     * @return：分页封装数据信息
     */
    /**
     *
     * @param practiceSubject：学科信息
     * @param pageDto：分页信息数据封装信息（需要展示的页码等信息）
     * @return：分页封装数据信息
     */
    PageDto<PracticeSubject> querySubjectLike(PracticeSubject practiceSubject, PageDto pageDto);

}
