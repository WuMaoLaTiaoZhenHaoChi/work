package com.sjkcxx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjkcxx.base.PageDto;
import com.sjkcxx.entity.PracticeSubject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/1 16:27
 * @Description:实践课程mapper
 */
public interface PracticeSubjectMapper extends BaseMapper<PracticeSubject> {

    /**
     * 更新学科已选人数
     * @param subject
     * @return
     */
    int updateSubjectPeopleNow(@Param("subject") PracticeSubject subject);

    /**
     * 统计数量，分页
     * @param subject
     * @return
     */
    int countSubjectBySubject(@Param("subject") PracticeSubject subject);

    /**
     * 多条件查询
     * @param subject
     * @return
     */
    List<PracticeSubject> selectSubjectBySubject(@Param("subject") PracticeSubject subject, @Param("pageDto") PageDto pageDto);

}
