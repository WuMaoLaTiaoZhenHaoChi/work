package com.pdjh.controller;

import com.pdjh.base.OrderFlag;
import com.pdjh.base.PageDto;
import com.pdjh.base.ResultVo;
import com.pdjh.entity.Order;
import com.pdjh.entity.UserInfo;
import com.pdjh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @PostMapping("/consumer/rateOrder")
    public ResultVo rateOrder(Order order){
        int i = orderService.consumberRateOrder(order);
        if (i >= 0){
            return ResultVo.success();
        }
        return ResultVo.build("500","评价失败，评分不符合规则");
    }

    /**
     * 员工结束订单
     * @param order
     * @return
     */
    @PutMapping("/employee/endMyOrder")
    public ResultVo endMyOrder(Order order){
        int i = orderService.employeeEndOrder(order);
        if (i >= 0){
            return ResultVo.success();
        }
        return ResultVo.build("500","关闭订单失败，此订单已被关闭");
    }

    /**
     * 员工查看自己的所有
     * @param order
     * @param pageDto
     * @param session
     * @return
     */
    @GetMapping("/employee/listOrder")
    public ResultVo employeeOrder(Order order, PageDto pageDto,HttpSession session){
        pageDto = orderService.listConsumerMyOrder(order, pageDto);
        return ResultVo.build("0","success",pageDto);
    }

    /**
     * 员工查看自己的订单
     * @param order
     * @param pageDto
     * @param session
     * @return
     */
    @GetMapping("/employee/listMyOrder")
    public ResultVo employeeMyOrder(Order order, PageDto pageDto,HttpSession session){
        if (order.getCustomerNum() == null || order.getCustomerNum().equals("")){
            UserInfo user = (UserInfo) session.getAttribute("user");
            String employeeNum = user.getUserNum();
            order.setEmployeeNum(employeeNum);
            pageDto = orderService.listConsumerMyOrder(order, pageDto);
        }
        return ResultVo.build("0","success",pageDto);
    }

    /**
     * 受理订单
     * @param order
     * @return
     */
    @PutMapping("/employee/accpeptOrder")
    public ResultVo employeeAcceptOrder(Order order){
        int i = orderService.employeeAcceptOrder(order);
        if (i >= 0){
            return ResultVo.success();
        }
        return ResultVo.build("500","受理失败，此订单已被取消或订单已结束");
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
        return ResultVo.build("500","取消失败，订单已受理或订单已结束");

    }

    /**
     * 客户查询历史预约记录
     * @param order
     * @return
     */
    @GetMapping("/consumer/listMyOrder")
    public ResultVo consumerListMyOrder(Order order, PageDto pageDto,HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        order.setCustomerNum(user.getUserNum());
        PageDto pageDtoR = orderService.listConsumerMyOrder(order, pageDto);
        return ResultVo.build("0","success",pageDtoR);
    }

    /**
     * 预约业务
     * @param order
     * @return
     */
    @PostMapping("/consumer/insertOrder")
    public ResultVo insertOrder(Order order,HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        int rankNum = orderService.qryCustomerRank(user);
        boolean save = orderService.inputOrderByOrder(order);
        if (save){
            return ResultVo.build("200",String.valueOf(rankNum),String.valueOf(rankNum));
        }
        return ResultVo.build("500","预约失败");
    }

}
