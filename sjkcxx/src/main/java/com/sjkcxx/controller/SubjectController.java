package com.sjkcxx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sjkcxx.base.PageDto;
import com.sjkcxx.base.ResultVo;
import com.sjkcxx.entity.PracticeSubject;
import com.sjkcxx.entity.StudentSubject;
import com.sjkcxx.entity.UserInfo;
import com.sjkcxx.mapper.PracticeSubjectMapper;
import com.sjkcxx.service.PracticeSubjectService;
import com.sjkcxx.service.StudentSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: duant
 * @Date: 2020/3/7 15:37
 * @Description:
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private PracticeSubjectService practiceSubjectService;
    @Autowired
    private StudentSubjectService studentSubjectService;

    //审核课程
    @PutMapping("/admin/checkSubject")
    public ResultVo checkSubject(PracticeSubject subject){
        int i = practiceSubjectService.adminCheckSubject(subject);
        if (i > 0){
            return ResultVo.success();
        }
        return ResultVo.build("500","审核出错了，请重新操作");
    }

    //学生签到
    @PutMapping("/student/sign")
    public ResultVo studentSign(StudentSubject studentSubject){
        int i = studentSubjectService.studentSign(studentSubject);
        if (i == -1){
            return ResultVo.build("200","课程还未开始或已经结课，暂不能签到");
        }else if (i == 0){
            return ResultVo.build("200","今天已经签到过了，切勿重复签到");
        }
        return ResultVo.build("200","签到成功，请继续保持");

    }

    //学生打分
    @PostMapping("/student/studentRateSubject")
    public ResultVo studentRateSubject(StudentSubject studentSubject){
        int i = studentSubjectService.studentScoreRate(studentSubject);
        if (i > 0){
            return ResultVo.success();
        }
        return ResultVo.build("500","打分失败，信息有误");
    }
    
    //学生自己的课程列表
    @GetMapping("/student/listMySubject")
    public ResultVo listStudentMySubject(StudentSubject studentSubject,PageDto pageDto,HttpSession session){
        String studentNum = studentSubject.getStudentNum();
        if (studentNum == null || studentNum.equals("")){
            UserInfo user = (UserInfo) session.getAttribute("user");
            studentSubject.setStudentNum(user.getUserNum());
        }
        PageDto<StudentSubject> studentSubjectPageDto = studentSubjectService.queryStudentSubjectLike(studentSubject, pageDto);
        return ResultVo.build("0", "success", studentSubjectPageDto);
    }


    //学生查询所有学科
    @GetMapping("/student/listAllSubject")
    public ResultVo studentQueryAllsubject( PracticeSubject practiceSubject,PageDto pageDto) {
        PageDto<PracticeSubject> practiceSubjectPageDto = practiceSubjectService.studentQuerySubjectLike(practiceSubject, pageDto);
        return ResultVo.build("0", "success", practiceSubjectPageDto);
    }


    //学生自己的课程列表
    @GetMapping("/teacher/listMyStudent")
    public ResultVo teacherListMyStudent(StudentSubject studentSubject,PageDto pageDto,HttpSession session){
        String teacherNum = studentSubject.getTeacherNum();
        if (teacherNum == null || teacherNum.equals("")){
            UserInfo user = (UserInfo) session.getAttribute("user");
            studentSubject.setTeacherNum(user.getUserNum());
        }
        PageDto<StudentSubject> studentSubjectPageDto = studentSubjectService.queryStudentSubjectLike(studentSubject, pageDto);
        return ResultVo.build("0", "success", studentSubjectPageDto);
    }

    //选课
    @PostMapping("/student/studentSelectSubject")
    public ResultVo studentSelectSubject(PracticeSubject subject, StudentSubject studentSubject){
        Object obj = practiceSubjectService.studentSelectSubject(subject, studentSubject);
        if (obj instanceof PracticeSubject){
            PracticeSubject subject1 = (PracticeSubject)obj;
            return ResultVo.build("201","课程时间冲突，你已在 [" + subject1.getSubjectStartTime() + "] - ["
                    + subject1.getSubjectEndTime() + "] 时间段内选择了课程，请重新选择 " );
        }else if ((int)obj > 0){
            return ResultVo.success();
        }
        return ResultVo.build("400","选课失败,请联系管理员");

    }

    //移除课程信息
    @RequestMapping("/teacher/removeSubject")
    public ResultVo removeSubject(PracticeSubject practiceSubject, HttpSession session){
        int i = practiceSubjectService.removeSubject(practiceSubject);
        if (i > 0){
            return ResultVo.build("200","此学科已被成功移除");
        }
        return ResultVo.build("500", "移除课程失败");
    }

    //插入课程
    @RequestMapping("/teacher/insertSubject")
    public ResultVo inserPrtoject(PracticeSubject practiceSubject, HttpSession session) {
        PracticeSubject subject = practiceSubjectService.getById(practiceSubject.getSubjectNum());
        if (subject != null) {
            return ResultVo.build("500", "课程编码不能重复");
        }
        int i = practiceSubjectService.inputSubject(practiceSubject);
        if (i == -1){
            return ResultVo.build("500", "场地冲突，请重新输入场地");
        }
        UserInfo user = (UserInfo) session.getAttribute("user");
        practiceSubject.setTeacherNum(user.getUserNum());
        boolean b = practiceSubjectService.save(practiceSubject);
        if (b) {
            return ResultVo.success();
        }
        return ResultVo.build("500", "新增课程失败");
    }


    //教师打分
    @PostMapping("/teacher/putGrade")
    public ResultVo setGrade(StudentSubject studentSubject){
        int i = studentSubjectService.gradeToStudent(studentSubject);
        if (i > 0){
            return ResultVo.success();
        }
        return ResultVo.build("500","系统异常，打分失败");
    }

    //教师查询所有学科
    @GetMapping("/teacher/listAllSubject")
    public ResultVo teacherQueryAllsubject( PracticeSubject practiceSubject,PageDto pageDto) {
        PageDto<PracticeSubject> practiceSubjectPageDto = practiceSubjectService.querySubjectLike(practiceSubject, pageDto);
        return ResultVo.build("0", "success", practiceSubjectPageDto);
    }

    //查询教师自己的学科
    @GetMapping("/teacher/listMySubject")
    public ResultVo querysubjectByTeachehNum(HttpSession session, PracticeSubject practiceSubject, PageDto pageDto) {
        UserInfo userinfo = (UserInfo) session.getAttribute("user");
        if (practiceSubject.getSubjectNum() == null || practiceSubject.getSubjectNum().equals("")){
            practiceSubject.setTeacherNum(userinfo.getUserNum());
        }
        PageDto<PracticeSubject> practiceSubjectPageDto = practiceSubjectService.querySubjectLike(practiceSubject, pageDto);
        return ResultVo.build("0", "success", practiceSubjectPageDto);
    }

    //修改学科
    @PostMapping("/teacher/updateMySubject")
    public ResultVo updatesubject(PracticeSubject practiceSubject) {
        practiceSubject.setSubjectCheck("未审核");//修改过后状态为未审核
        boolean updateById = practiceSubjectService.updateById(practiceSubject);
        if (updateById) {
            return ResultVo.success();
        }
        return ResultVo.build("0", "更新失败");
    }

}
