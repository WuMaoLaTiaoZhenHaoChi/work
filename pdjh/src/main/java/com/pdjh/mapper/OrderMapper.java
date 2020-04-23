package com.pdjh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pdjh.base.PageDto;
import com.pdjh.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/29 10:42
 * @Description:
 */
public interface OrderMapper extends BaseMapper<Order> {

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
