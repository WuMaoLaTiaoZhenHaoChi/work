package com.sjkcxx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: duant
 * @Date: 2020/2/29 22:56
 * @Description:实践课程表
 */
@TableName("practice_subject")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PracticeSubject implements Serializable {

    @TableId(type = IdType.INPUT)
    private String subjectNum;              //课程编号

    private String subjectName;             //课程名称

    private String subjectDepartment;              //院系

    private String subjectType;             //课程类别

    private String subjectCheck;            //是否审核0：未审核 1：已审核

    private String subjectMain;             //课程简介

    private Integer subjectPeopleNow;       //课程现有人数

    private Integer subjectPeopleMax;       //课程人数

    private String subjectStartTime;        //课程开课日期
    private String subjectEndTime;        //课程结束时间

    private String subjectRequire;          //课程要求

    private Float subjectScore;             //课程评分

    private String teacherNum;              //教师编号

    private String teacherName;             //教师姓名

    private String inputTime;               //录入时间


    private String sortType;                //排序规则

}
