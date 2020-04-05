package com.sjkcxx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sjkcxx.base.ResultVo;
import com.sjkcxx.entity.PracticeSubject;
import com.sjkcxx.entity.UserInfo;
import com.sjkcxx.mapper.PracticeSubjectMapper;
import com.sjkcxx.service.PracticeSubjectService;
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

    //插入课程
    @RequestMapping("/teacher/insertSubject")
    public ResultVo inserPrtoject(PracticeSubject practiceSubject, HttpSession session) {
        PracticeSubject subject = practiceSubjectService.getById(practiceSubject.getSubjectNum());
        if (subject != null) {
            return ResultVo.build("400", "课程编码不能重复");
        }
        UserInfo user = (UserInfo) session.getAttribute("user");
        practiceSubject.setTeacherNum(user.getUserNum());
        boolean b = practiceSubjectService.save(practiceSubject);
        if (b) {
            return ResultVo.success();
        }
        return ResultVo.build("400", "新增课程失败");
    }

    //查询所有学科
    @GetMapping("/teacher/listAllSubject")
    public ResultVo queryAllsubject( PracticeSubject practiceSubject) {
        List<PracticeSubject> subjectList = practiceSubjectService.querySubjectLike(practiceSubject);

        int count = subjectList.size();
        return ResultVo.build("0", "success", count, subjectList);
    }

    //查询教师自己的学科
    @GetMapping("/teacher/listMySubject")
    public ResultVo querysubjectByTeachehNum(HttpSession session,PracticeSubject practiceSubject) {
        UserInfo userinfo = (UserInfo) session.getAttribute("user");
        if (practiceSubject.getSubjectNum() == null || practiceSubject.getSubjectNum().equals("")){
            practiceSubject.setTeacherNum(userinfo.getUserNum());
        }
        List<PracticeSubject> subjectList = practiceSubjectService.querySubjectLike(practiceSubject);
        int count = subjectList.size();
        return ResultVo.build("0", "success", count, subjectList);
    }

    //修改学科
    @PostMapping("/teacher/updateMySubject")
    public ResultVo updatesubject(PracticeSubject practiceSubject) {
        boolean updateById = practiceSubjectService.updateById(practiceSubject);
        if (updateById) {
            return ResultVo.success();
        }
        return ResultVo.build("0", "更新失败");
    }

}