package com.pdjh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: duant
 * @Date: 2020/3/29 10:21
 * @Description:客户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("customer_info")
public class CustomerInfo extends UserInfo {

    @TableId(type = IdType.INPUT)
    private String userNum;         //客户编号

    private String customerLevel;    //客户等级

}
