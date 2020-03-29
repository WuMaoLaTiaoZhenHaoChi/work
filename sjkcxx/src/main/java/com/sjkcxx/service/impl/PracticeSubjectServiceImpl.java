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

    @Autowired(required = false)
    private PracticeSubjectMapper practiceSubjectMapper;

    @Override
    public List<PracticeSubject> querySubjectLike(PracticeSubject practiceSubject) {
        List<PracticeSubject> practiceSubjects = practiceSubjectMapper.selectSubjectBySubject(practiceSubject);
        return practiceSubjects;
    }
}
