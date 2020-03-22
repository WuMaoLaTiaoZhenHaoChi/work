package com.sjkcxx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjkcxx.entity.PracticeSubject;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/7 15:08
 * @Description:实践课程service
 */
public interface PracticeSubjectService extends IService<PracticeSubject> {

    /**
     * 模糊查询学科信息
     * @param practiceSubject
     * @return
     */
    List<PracticeSubject> querySubjectLike(PracticeSubject practiceSubject);

}
