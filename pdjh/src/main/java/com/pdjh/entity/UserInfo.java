package com.pdjh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: duant
 * @Date: 2020/3/1 16:22
 * @Description:用户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_info")
public class UserInfo {

    @TableId(type = IdType.INPUT)
    private String userNum;

    private String userPwd;

    private String userType;

}
