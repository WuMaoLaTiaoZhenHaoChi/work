package com.sjkcxx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjkcxx.entity.PracticeSubject;
import com.sjkcxx.mapper.PracticeSubjectMapper;
import com.sjkcxx.service.PracticeSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/7 15:09
 * @Description:
 */
@Service
public class PracticeSubjectServiceImpl extends ServiceImpl<PracticeSubjectMapper, PracticeSubject> implements PracticeSubjectService {

    @Resource
    private PracticeSubjectMapper practiceSubjectMapper;

    @Override
    public List<PracticeSubject> querySubjectLike(PracticeSubject practiceSubject) {
        QueryWrapper<PracticeSubject> subjectQueryWrapper = new QueryWrapper<>();
        subjectQueryWrapper.like("teacher_num", practiceSubject.getTeacherNum());
        subjectQueryWrapper.like("subject_name", practiceSubject.getSubjectNum());
        subjectQueryWrapper.like("subject_type", practiceSubject.getSubjectType());
        practiceSubjectMapper.selectMaps(subjectQueryWrapper);

        return null;
    }
}
