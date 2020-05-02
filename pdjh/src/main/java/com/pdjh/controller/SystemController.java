package com.pdjh.controller;

import com.pdjh.base.ResultVo;
import com.pdjh.entity.Order;
import com.pdjh.entity.UserInfo;
import com.pdjh.mapper.OrderMapper;
import com.pdjh.service.OrderService;
import com.pdjh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: duant
 * @Date: 2020/3/1 17:10
 * @Description:
 */
@RestController
@RequestMapping("/sys")
public class SystemController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;


    @PostMapping("/login")
    public ResultVo verifyLogin(UserInfo userInfo, HttpServletRequest request){
        UserInfo user = userService.getById(userInfo.getUserNum());

        int rankNum = 0;

        Order order = new Order();
        order.setCustomerNum(user.getUserNum());
        order.setOrderFlag("已受理");
        int i = orderMapper.countOrderByOrder(order);
        if (i > 0){
            rankNum = 0;
        }else {
            rankNum = orderService.qryCustomerRank(user);
        }

        if (user != null && user.getUserPwd().equals(userInfo.getUserPwd()) && user.getUserType().equals(userInfo.getUserType())){
            request.getSession().setAttribute("user",user);
            return ResultVo.build("200",String.valueOf(rankNum),user);
//            return ResultVo.success();
        }
        return ResultVo.build("400","用户无效或密码错误！");
    }

}
