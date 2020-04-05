package com.pdjh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pdjh.base.PageDto;
import com.pdjh.entity.Order;
import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/29 10:47
 * @Description:
 */
public interface OrderService extends IService<Order> {

    /**
     * 客户进行订单评级
     * @param order
     * @return
     */
    int consumberRateOrder(Order order);

    /**
     * 员工已处理并关闭订单
     * @param order
     * @return
     */
    int employeeEndOrder(Order order);

    /**
     * 员工受理预约
     * @param order
     * @return
     */
    int employeeAcceptOrder(Order order);

    /**
     * 客户取消预约
     * @param order
     * @return
     */
    int consumerCancelOrder(Order order);

    /**
     * 客户预约单子
     * @param order
     * @return
     */
    boolean inputOrderByOrder(Order order);

    /**
     * 客户订单记录
     * @param order
     * @return
     */
    PageDto<Order> listConsumerMyOrder(Order order, PageDto<Order> pageDto);

}
