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

    private String studentNum;

    private String subjectNum;

    private String subjectEnd;

    private Float subjectGrade;

    private Float subjectWork;

    private Float subjectScore;

    private Float subjectRemark;

}
