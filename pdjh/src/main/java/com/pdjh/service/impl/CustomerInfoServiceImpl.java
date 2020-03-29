package com.pdjh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pdjh.entity.CustomerInfo;
import com.pdjh.mapper.CustomerMapper;
import com.pdjh.service.CustomerInfoService;
import org.springframework.stereotype.Service;

/**
 * @Author: duant
 * @Date: 2020/3/29 10:45
 * @Description:
 */
@Service
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerMapper, CustomerInfo> implements CustomerInfoService {
}
