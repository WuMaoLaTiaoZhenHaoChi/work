package com.pdjh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: duant
 * @Date: 2020/3/28 17:01
 * @Description:员工
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("employee_info")
public class EmployeeInfo {

    @TableId(type = IdType.INPUT)
    private String userNum;     //员工编号

    private String employeeDept;    //员工部门

    private Float employeeGrade;    //员工评分

    private String userName;    //用户姓名

    private String userPwd;     //用户密码

    private String userType;    //用户权限（0：客户，1：银行员工，2：管理员）

}
