package com.pdjh.entity;

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
    private String userNum;     //用户编号

    private String userName;    //用户姓名

    private String userPwd;     //用户密码

    private String userType;    //用户权限（0：客户，1：银行员工，2：管理员）

    private String customerLevel;    //客户等级

}
