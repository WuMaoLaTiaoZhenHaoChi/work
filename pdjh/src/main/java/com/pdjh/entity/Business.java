package com.pdjh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: duant
 * @Date: 2020/3/29 10:23
 * @Description:业务
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("business")
public class Business {

    @TableId(type = IdType.INPUT)
    private String businessNum;        //业务编号

    private String businessName;       //业务名称

    private String businessType;       //业务类型

    private String businessDescription;    //业务描述

    private Float businessGrade;      //业务评分

}
