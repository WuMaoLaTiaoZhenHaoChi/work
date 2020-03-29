package com.sjkcxx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjkcxx.entity.PracticeSubject;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/1 16:27
 * @Description:实践课程mapper
 */
public interface PracticeSubjectMapper extends BaseMapper<PracticeSubject> {

    /**
     * 多条件查询
     * @param subject
     * @return
     */
    List<PracticeSubject> selectSubjectBySubject(PracticeSubject subject);

}
