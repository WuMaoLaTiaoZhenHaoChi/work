package com.pdjh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pdjh.base.PageDto;
import com.pdjh.entity.Order;
import com.pdjh.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/29 10:42
 * @Description:
 */
public interface OrderMapper extends BaseMapper<Order> {


    /**
     * 移除未处理的订单
     * @param order
     * @return
     */
    int removeOrder(@Param("order") Order order);

    /**
     * 更心订单中用户等级
     * @param user
     * @return
     */
    int updataOrderCustomerLeave(@Param("user") UserInfo user);

    /**
     * 查询排位号
     * @param user
     * @return
     */
    int selectRankByUser(@Param("user") UserInfo user);

    /**
     * 清空数据
     * @return
     */
    Integer clearData();

    /**
     * 统计数量
     * @param order
     * @return
     */
    int countOrderByOrder(@Param("order") Order order);

    /**
     * 自定义查询自己订单记录
     * @param order
     * @return
     */
    List<Order> selectOrderByOrder(@Param("order") Order order,@Param("pageDto") PageDto<Order> pageDto);

    /**
     * 通过订单号更改订单状态
     * @param order
     * @return
     */
//    Boolean updateConsumerOrderFlag(@Param("orderNum") String orderNum,@Param("orderFlag") String orderFlag);
    int updateConsumerOrderFlag(@Param("order") Order order);

}
