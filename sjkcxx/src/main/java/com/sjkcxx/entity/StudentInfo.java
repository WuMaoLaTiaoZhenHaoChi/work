package com.sjkcxx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * @Author: duant
 * @Date: 2020/2/29 21:15
 * @Description:学生表
 */
@TableName("student_info")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentInfo extends UserInfo {

    @TableId(type = IdType.INPUT)
    private String userNum;

    private String userName;

    private String studentSpecialtyNum;

}
