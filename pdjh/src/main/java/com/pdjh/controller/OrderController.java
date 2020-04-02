package com.pdjh.controller;

import com.pdjh.base.OrderFlag;
import com.pdjh.base.PageDto;
import com.pdjh.base.ResultVo;
import com.pdjh.entity.Order;
import com.pdjh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/28 16:52
 * @Description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PutMapping("/employee/accpeptOrder")
    public ResultVo employeeAcceptOrder(Order order){
        int i = orderService.employeeAcceptOrder(order);
        if (i >= 0){
            return ResultVo.success();
        }
        return ResultVo.build("400","受理失败，此订单已被取消或订单已结束");
    }

    /**
     * 取消订单，不是删除，只更改状态
     * @param order
     * @return
     */
    @PutMapping("/consumer/removeMyOrder")
    public ResultVo consumerDeleteMyOrder(Order order){
        int b = orderService.consumerCancelOrder(order);
        if (b >= 0){
            return ResultVo.success();
        }
        return ResultVo.build("400","取消失败，订单已受理或订单已结束");

    }

    /**
     * 客户查询利是预约记录
     * @param order
     * @return
     */
    @GetMapping("/consumer/listMyOrder")
    public ResultVo consumerListMyOrder(Order order, PageDto pageDto){
        PageDto pageDtoR = orderService.listConsumerMyOrder(order, pageDto);
        return ResultVo.build("0","success",pageDtoR);
    }

    /**
     * 预约业务
     * @param order
     * @return
     */
    @PostMapping("/consumer/insertOrder")
    public ResultVo insertOrder(Order order){
        boolean save = orderService.inputOrderByOrder(order);
        if (save)
            return ResultVo.success();
        else
            return ResultVo.build("500","预约失败");
    }

}
