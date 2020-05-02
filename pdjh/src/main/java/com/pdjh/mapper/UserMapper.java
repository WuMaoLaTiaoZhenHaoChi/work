package com.pdjh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pdjh.base.PageDto;
import com.pdjh.entity.Order;
import com.pdjh.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: duant
 * @Date: 2020/3/1 16:26
 * @Description:用户mapper
 */
public interface UserMapper extends BaseMapper<UserInfo> {

    /**
     * 自定义用户
     * @param
     * @return
     */
    List<Order> selectUserList(@Param("userInfo") UserInfo userInfo, @Param("pageDto") PageDto<Order> pageDto);


}
