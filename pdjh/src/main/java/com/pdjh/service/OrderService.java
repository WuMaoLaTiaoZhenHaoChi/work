package com.pdjh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pdjh.base.PageDto;
import com.pdjh.entity.Order;
import com.pdjh.entity.UserInfo;
import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/29 10:47
 * @Description:订单业务
 */
public interface OrderService extends IService<Order> {
    /**
     * 客户拍的号
     * @param userInfo
     * @return  客户所在排号位数
     */
    int qryCustomerRank(UserInfo userInfo);

    /**
     * 客户进行订单评级
     * @param order：订单信息
     * @return  评级成功返回标识 0：失败 1：成功
     */
    int consumberRateOrder(Order order);
    /**
     * 员工已处理并关闭订单
     * @param order：订单信息
     * @return 员工处理订单返回标识 0：失败 1：成功
     */
    int employeeEndOrder(Order order);
    /**
     * 员工受理预约
     * @param order：订单信息
     * @return 员工受理预约订单返回标识 0：失败 1：成功
     */
    int employeeAcceptOrder(Order order);
    /**
     * 客户取消预约
     * @param order：订单信息
     * @return  客户取消预约订单返回标识 0：失败 1：成功
     */
    int consumerCancelOrder(Order order);
    /**
     * 客户预约单子
     * @param order
     * @return 客户预约订单返回标识 false：失败 true：成功
     */
    boolean inputOrderByOrder(Order order);

    /*
     * @param order：订单信息
     * @param pageDto：分页信息和返回数据信息(查展示的页码等信息)
     * @return  返回用户订单数据信息列表
     */
    PageDto<Order> listConsumerMyOrder(Order order, PageDto<Order> pageDto);

}
