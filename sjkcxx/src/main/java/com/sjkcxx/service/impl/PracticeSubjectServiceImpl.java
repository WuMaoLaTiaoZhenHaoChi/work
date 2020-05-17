package com.sjkcxx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjkcxx.base.PageDto;
import com.sjkcxx.entity.PracticeSubject;
import com.sjkcxx.entity.StudentSubject;
import com.sjkcxx.mapper.PracticeSubjectMapper;
import com.sjkcxx.mapper.StudentSubjectMapper;
import com.sjkcxx.service.PracticeSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/7 15:09
 * @Description:
 */
@Service
public class PracticeSubjectServiceImpl extends ServiceImpl<PracticeSubjectMapper, PracticeSubject> implements PracticeSubjectService {

    @Autowired
    private PracticeSubjectMapper practiceSubjectMapper;
    @Autowired
    private StudentSubjectMapper studentSubjectMapper;

    //移除学科信息，逻辑删除
    @Override
    public int removeSubject(PracticeSubject practiceSubject) {
        String subjectNum = practiceSubject.getSubjectNum();
        PracticeSubject subject = practiceSubjectMapper.selectById(subjectNum);
        if (subject.getSubjectPeopleNow() > 0){
            return -1;
        }
        subject.setSubjectCheck("已移除");
        int i = practiceSubjectMapper.updateById(subject);
        return i;
    }

    //审核课程
    @Override
    public int adminCheckSubject(PracticeSubject practiceSubject) {
        String subjectNum = practiceSubject.getSubjectNum();
        String subjectCheck = practiceSubject.getSubjectCheck();
        if (subjectNum == null || subjectNum.equals(""))
            return  -1;
        if (subjectCheck == null || subjectCheck.equals(""))
            return -1;
        PracticeSubject practiceSubjectSelect = practiceSubjectMapper.selectById(subjectNum);
        practiceSubjectSelect.setSubjectCheck(subjectCheck);
        int i = practiceSubjectMapper.updateById(practiceSubjectSelect);
        return i;
    }

    //学生选课
    @Transactional
    @Override
    public Object studentSelectSubject(PracticeSubject subject, StudentSubject studentSubject) {
        String subjectNum = subject.getSubjectNum();
        if (subjectNum == null || subjectNum.equals(""))
            return -1;

        PracticeSubject practiceSubject = studentSubjectMapper.selectSubjectTime(studentSubject);
        if (practiceSubject != null){
            if (practiceSubject.getSubjectStartTime() != null || practiceSubject.getSubjectEndTime() != null){
                return practiceSubject;
            }
        }

        Integer subjectPeopleNow = subject.getSubjectPeopleNow();
        Integer subjectPeopleMax = practiceSubjectMapper.selectById(subjectNum).getSubjectPeopleMax();
        if (subjectPeopleNow >= subjectPeopleMax){
            return -1;
        }
        String teacherNum = subject.getTeacherNum();
        subject.setSubjectPeopleNow(subjectPeopleNow + 1);

        //更新学科信息
        int i = practiceSubjectMapper.updateSubjectPeopleNow(subject);
        //插入
        studentSubject.setSubjectName(studentSubject.getSubjectName());
        studentSubject.setTeacherNum(teacherNum);
        studentSubject.setStudentSubjectNum(subjectNum + studentSubject.getStudentNum());
        studentSubject.setSubjectNum(subjectNum);
        int insert = studentSubjectMapper.insert(studentSubject);
        return i & insert;
    }

    //学生查询已审核的
    @Override
    public PageDto<PracticeSubject> studentQuerySubjectLike(PracticeSubject practiceSubject, PageDto pageDto) {
        pageDto.calculateCurrent();
        List<PracticeSubject> practiceSubjectList = practiceSubjectMapper.studentSelectSubjectBySubject(practiceSubject,pageDto);
        int count = practiceSubjectMapper.studentCountSubjectBySubject(practiceSubject);
        pageDto.setCount(count);
        pageDto.setData(practiceSubjectList);
        return pageDto;
    }

    //查询课程
    @Override
    public PageDto<PracticeSubject> querySubjectLike(PracticeSubject practiceSubject, PageDto pageDto) {
        pageDto.calculateCurrent();
        List<PracticeSubject> practiceSubjectList = practiceSubjectMapper.selectSubjectBySubject(practiceSubject,pageDto);
        int count = practiceSubjectMapper.countSubjectBySubject(practiceSubject);
        pageDto.setCount(count);
        pageDto.setData(practiceSubjectList);
        return pageDto;
    }
}
