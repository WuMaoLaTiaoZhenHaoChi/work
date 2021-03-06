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
 * @Date: 2020/3/1 16:22
 * @Description:用户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_info")
public class UserInfo implements Serializable {

    @TableId(type = IdType.INPUT)
    private String userNum;

    private String userName;

    private String userPwd;

    private String userType;

    private String userSpecialty;

    private String userClass;

}
