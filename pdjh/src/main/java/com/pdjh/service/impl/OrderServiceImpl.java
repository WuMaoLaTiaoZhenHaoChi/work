package com.pdjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pdjh.base.OrderFlag;
import com.pdjh.base.PageDto;
import com.pdjh.base.ResultVo;
import com.pdjh.entity.Order;
import com.pdjh.mapper.OrderMapper;
import com.pdjh.service.OrderService;
import com.pdjh.util.DateUtils;
import com.sun.tools.corba.se.idl.constExpr.Or;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/29 10:47
 * @Description:
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int consumberRateOrder(Order order) {
        if (order.getOrderGrade() == null || order.getOrderGrade().equals(""))
            return -1;
        int i = orderMapper.updateConsumerOrderFlag(order);
        return i;
    }

    //员工已处理并关闭订单
    @Override
    public int employeeEndOrder(Order order) {
        String orderFlag = order.getOrderFlag();
        if (order == null || orderFlag.equals(OrderFlag.ORDER_FLAG_2)){
            return -1;
        }
        order.setOrderFlag(OrderFlag.ORDER_FLAG_2);
        int i = orderMapper.updateConsumerOrderFlag(order);
        return i;
    }

    //员工受理订单
    @Override
    public int employeeAcceptOrder(Order order) {
        String orderFlag = order.getOrderFlag();
        if (orderFlag == null || !orderFlag.equals(OrderFlag.ORDER_FLAG_0))
            return -1;
        order.setOrderFlag(OrderFlag.ORDER_FLAG_1);
        int i = orderMapper.updateById(order);
        return i;
    }

    //客户取消预约
    @Override
    public int consumerCancelOrder(Order order) {
        //只有客户订单状态为未受理的时候才能取消
        int i = -1;
        if (order != null && order.getOrderFlag().equals(OrderFlag.ORDER_FLAG_0)){
            order.setOrderFlag(OrderFlag.ORDER_FLAG_3);
            i = orderMapper.updateConsumerOrderFlag(order);
        }
        return i;
    }

    //客户预约单子
    @Override
    public boolean inputOrderByOrder(Order order) {
        if (order == null)
            return false;
        String dateNow = DateUtils.getDate("yyyyMMddHHmmss");
        String orderNum = order.getCustomerNum().concat(dateNow);

        order.setOrderNum(orderNum);
        order.setOrderCreatTime(dateNow);

        int insert = orderMapper.insert(order);

        return insert > 0 ? true : false;
    }

    //客户订单列表
//    @Override
//    public PageDto<Order> listConsumerMyOrder(Order order, PageDto<Order> pageDto) {
//        pageDto.calculateCurrent();
//        IPage<Order> iPage = new Page<>(pageDto.getCurrent(),pageDto.getLimit());
//        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
//        orderQueryWrapper.isNull("customer_num").like("customer_num",order.getCustomerNum())
//                .or().isNull("business_type").like("business_type",order.getBusinessType())
//                .or().isNull("employee_num").like("employee_num",order.getEmployeeNum());
//        IPage<Order> iPage1 = orderMapper.selectPage(iPage, orderQueryWrapper);
//
//        return pageDto;
//    }

    //客户订单列表
    @Override
    public PageDto<Order> listConsumerMyOrder(Order order, PageDto<Order> pageDto) {
        pageDto.calculateCurrent();
        List<Order> orderList = orderMapper.selectOrderByOrder(order,pageDto);
        int count = orderMapper.countOrderByOrder(order);
//        int count = this.count();
        pageDto.setCount(count);
        pageDto.setData(orderList);
        return pageDto;
    }

}
