package com.sjkcxx.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
public class UserExcelInfo implements Serializable {
    @Excel(name = "用户账号")
    private String userNum;

    @Excel(name = "姓名")
    private String userName;

    @Excel(name = "密码")
    private String userPwd;

    @Excel(name = "用户类型")
    private String userType;

    @Excel(name = "院系")
    private String userSpecialty;

    @Excel(name = "班级")
    private String userClass;

    public UserInfo getUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserNum(userNum);
        userInfo.setUserName(userName);
        userInfo.setUserPwd(userPwd);
        userInfo.setUserType(userType);
        userInfo.setUserSpecialty(userSpecialty);
        if (userType != null && userType.equals("") && userType.equals("1")){
            userInfo.setUserClass(userClass);
        }
        return userInfo;
    }

}
