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
 * @Date: 2020/2/29 22:53
 * @Description:教师表
 */
@TableName("teacher_info")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher implements Serializable {

    @TableId(type = IdType.INPUT)
    private String teacherNum;

    private String teacherPhone;

    private String teacherRank;

    private String teacherPosition;

    private String teacherProfessional;

    private String teacherSpecialtyNum;


}
