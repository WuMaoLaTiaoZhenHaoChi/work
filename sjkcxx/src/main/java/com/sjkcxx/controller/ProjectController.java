package com.sjkcxx.controller;

import com.sjkcxx.base.ResultVo;
import com.sjkcxx.entity.PracticeSubject;
import com.sjkcxx.entity.UserInfo;
import com.sjkcxx.service.PracticeSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: duant
 * @Date: 2020/3/7 15:37
 * @Description:
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private PracticeSubjectService practiceSubjectService;

    //插入课程
    @RequestMapping("/teacher/insertProject")
    public ResultVo inserPrtoject(PracticeSubject practiceSubject, HttpSession session){
        PracticeSubject project = practiceSubjectService.getById(practiceSubject.getSubjectNum());
        if (project != null){
            return ResultVo.build("400","课程编码不能重复");
        }
        UserInfo user = (UserInfo) session.getAttribute("user");
        practiceSubject.setTeacherNum(user.getUserNum());
        boolean b = practiceSubjectService.save(practiceSubject);
        if (b){
            return ResultVo.success();
        }
        return ResultVo.build("400","新增课程失败");
    }

    //查询所有学科
    @RequestMapping("/teacher/listAllProject")
    public ResultVo queryAllProject(){

        List<PracticeSubject> projectList = practiceSubjectService.list();
        int count = projectList.size();
        return ResultVo.build("0","",count,projectList);
    }

    //查询教师自己的学科
    @RequestMapping("/teacher/listMyProject")
    public ResultVo queryProjectByTeachehNum(HttpSession session){
        HashMap<String, Object> columnMap = new HashMap<>();

        UserInfo user = (UserInfo) session.getAttribute("user");
        String teacherNum = user.getUserNum();
        columnMap.put("teacher_num",teacherNum);

        List<PracticeSubject> projectList = practiceSubjectService.listByMap(columnMap);
        int count = projectList.size();
        return ResultVo.build("0","",count,projectList);
    }

}
