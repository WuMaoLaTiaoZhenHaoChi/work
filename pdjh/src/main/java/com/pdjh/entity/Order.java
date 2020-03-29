package com.pdjh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: duant
 * @Date: 2020/3/29 10:31
 * @Description:订单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("order")
public class Order {

    @TableId(type = IdType.INPUT)
    private String orderNum;           //订单编号

    private String orderDescribe;      //订单描述

    private String orderCreatTime;    //订单创建时间

    private String orderEndTime;      //订单结束时间

    private String orderFlag;          //订单状态（0：已预约，1：已受理，2：已结束）

    private Float orderGrade;          //客户评分

    private String orderRemark;        //客户评价备注

    private String customerNum;        //预约客户编号

    private String employeeNum;        //受理员工编号

}
