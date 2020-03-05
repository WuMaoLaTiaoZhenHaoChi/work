package com.sjkcxx.entity;

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
    @TableId
    private String subjectNum;

    private String subjectName;

    private String subjectType;

    private String subjectCheck;

    private String subjectMain;

    private Integer subjectPeopleMax;

    private Date subjectStartTime;

    private String subjectRequire;

    private Float subjectScore;

    private String teacherNum;

}
