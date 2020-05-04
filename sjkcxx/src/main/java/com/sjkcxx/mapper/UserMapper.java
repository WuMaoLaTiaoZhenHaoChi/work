package com.sjkcxx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjkcxx.base.PageDto;
import com.sjkcxx.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;

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
    List selectUserList(@Param("userInfo") UserInfo userInfo, @Param("pageDto") PageDto pageDto);


    int countUserList(@Param("userInfo") UserInfo userInfo, @Param("pageDto") PageDto pageDto);


}
