package com.pdjh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pdjh.entity.Order;
import com.pdjh.mapper.OrderMapper;
import com.pdjh.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @Author: duant
 * @Date: 2020/3/29 10:47
 * @Description:
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
