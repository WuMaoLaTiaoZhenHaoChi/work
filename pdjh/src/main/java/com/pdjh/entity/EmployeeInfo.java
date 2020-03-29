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
public class EmployeeInfo extends UserInfo {

    @TableId(type = IdType.INPUT)
    private String userNum;     //员工编号

    private String employeeDept;    //员工部门

    private Float employeeGrade;    //员工评分

}
