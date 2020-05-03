package com.sjkcxx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: duant
 * @Date: 2020/2/29 23:03
 * @Description:学生-课程表
 */
@TableName("student_subject")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentSubject implements Serializable {

    @TableId(type = IdType.INPUT)
    private String studentSubjectNum;

    private String teacherNum;      //老师编号

    private String teacherName;     //教师姓名

    private String studentNum;      //学生编号

    private String studentName;     //学生姓名

    private String subjectNum;      //课程编号

    private String subjectName;     //课程名称

    private String subjectStatic;      //课程状态(未修完/已修完)

    private Float subjectGrade;     //课程成绩

    private String subjectWork;      //课程作业（路径）

    private Float subjectScore;     //课程评分

    private String subjectRemark;      //课程评价

    private int signTime;      //签到次数

    private String signDate;    //  签到时间

}
