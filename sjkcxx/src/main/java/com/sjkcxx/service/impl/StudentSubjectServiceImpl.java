package com.sjkcxx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjkcxx.base.PageDto;
import com.sjkcxx.entity.PracticeSubject;
import com.sjkcxx.entity.StudentSubject;
import com.sjkcxx.mapper.PracticeSubjectMapper;
import com.sjkcxx.mapper.StudentSubjectMapper;
import com.sjkcxx.service.PracticeSubjectService;
import com.sjkcxx.service.StudentSubjectService;
import com.sjkcxx.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/7 15:15
 * @Description:
 */
@Service
public class StudentSubjectServiceImpl extends ServiceImpl<StudentSubjectMapper, StudentSubject> implements StudentSubjectService {

    @Autowired
    private StudentSubjectMapper studentSubjectMapper;

    @Autowired
    private PracticeSubjectMapper subjectMapper;

    //学生签到
    @Override
    public int studentSign(StudentSubject studentSubject) {
        int flag = -1;              //-1 不能签到，0:已经签过到了
        String subjectNum = studentSubject.getSubjectNum();
        PracticeSubject subject = subjectMapper.selectById(subjectNum);

        String subjectStartTime = subject.getSubjectStartTime().replaceAll("-","");
        String subjectEndTime = subject.getSubjectEndTime().replaceAll("-","");
        String now = DateUtils.getDate("yyyyMMdd");
        int startTime = Integer.parseInt(subjectStartTime);
        int endTime = Integer.parseInt(subjectEndTime);
        int nowTime = Integer.parseInt(now);

        if (nowTime < startTime || nowTime > endTime){
            //不能签到
            return flag;
        }
        StudentSubject studentSubjectTemp = studentSubjectMapper.selectById(studentSubject.getStudentSubjectNum());
        String signDate = studentSubjectTemp.getSignDate();
        if (signDate != null){
            signDate = signDate.replaceAll("-","");
            if (now.equals(signDate) ){
                return 0;       //今天已经签到过了
            }
        }
        studentSubjectTemp.setSignTime(studentSubjectTemp.getSignTime() + 1);
        studentSubjectTemp.setSignDate(now);
        studentSubjectMapper.updateById(studentSubjectTemp);
        return 1;
    }

    /**
     * 上传作业
     * @param studentSubject
     * @return
     */
    @Override
    public int studentUpload(StudentSubject studentSubject) {
        int i = 0;
        String studentSubjectNum = studentSubject.getStudentSubjectNum();
        if (studentSubjectNum == null || studentSubjectNum.equals("")){
            return i;
        }
        StudentSubject subject = studentSubjectMapper.selectById(studentSubjectNum);
        subject.setSubjectWork(studentSubjectNum);
        subject.setSubjectWork(studentSubject.getSubjectWork());
        subject.setSubjectStatic("已提交实践报告");
        i = studentSubjectMapper.updateById(subject);
        return i;
    }

    //打成绩
    @Override
    public int gradeToStudent(StudentSubject studentSubject) {

        int i = -1;
        String studentSubjectNum = studentSubject.getStudentSubjectNum();
        if (studentSubjectNum == null || studentSubjectNum.equals("")){
            return i;
        }
        StudentSubject studentSubjectTemp = studentSubjectMapper.selectById(studentSubjectNum);
        studentSubjectTemp.setSubjectGrade(studentSubject.getSubjectGrade());
        studentSubjectTemp.setSubjectStatic("已打分");
        i = studentSubjectMapper.updateById(studentSubjectTemp);
        return i;
    }

    //学生打分
    @Override
    public int studentScoreRate(StudentSubject studentSubject) {
        int i = -1;
        String studentSubjectNum = studentSubject.getStudentSubjectNum();
        if (studentSubjectNum == null || studentSubjectNum.equals("")){
            return i;
        }
        StudentSubject studentSubjectTemp = studentSubjectMapper.selectById(studentSubjectNum);
        studentSubjectTemp.setSubjectScore(studentSubject.getSubjectScore());
        studentSubjectTemp.setSubjectRemark(studentSubject.getSubjectRemark());
        studentSubjectTemp.setSubjectStatic("已结束，已评价");
        i = studentSubjectMapper.updateById(studentSubjectTemp);
        return i;
    }

    //学生课程列表
    @Override
    public PageDto<StudentSubject> queryStudentSubjectLike(StudentSubject studentSubject, PageDto pageDto) {
        pageDto.calculateCurrent();
        List<StudentSubject> studentSubjects = studentSubjectMapper.selectStudentSubjectBySS(studentSubject, pageDto);
        int count = studentSubjectMapper.countStudentSubjectBySS(studentSubject);
        pageDto.setPageDto(count,studentSubjects);
        return pageDto;
    }

}
