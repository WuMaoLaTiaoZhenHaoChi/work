package com.pdjh.service.impl;

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

    //客户取消预约
    @Override
    public boolean consumerCancelOrder(Order order) {
        //只有客户订单状态为未受理的时候才能取消
        if (order != null && order.getOrderFlag().equals(OrderFlag.ORDER_FLAG_0)){
            boolean b = orderMapper.updateConsumerOrderFlag(order.getOrderNum(),OrderFlag.ORDER_FLAG_3);
            if (b){
                return true;
            }
            return false;
        }
        return false;
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
    @Override
    public PageDto<Order> listConsumerMyOrder(Order order, PageDto<Order> pageDto) {
        pageDto.calculateCurrent();
        List<Order> orderList = orderMapper.selectOrderByOrder(order,pageDto);
        int count = this.count();
        pageDto.setCount(count);
        pageDto.setData(orderList);
        return pageDto;
    }

}
