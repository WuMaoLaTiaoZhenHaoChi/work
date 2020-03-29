package com.pdjh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pdjh.entity.Business;
import com.pdjh.mapper.BusinessMapper;
import com.pdjh.service.BusinessService;
import org.springframework.stereotype.Service;

/**
 * @Author: duant
 * @Date: 2020/3/29 10:43
 * @Description:
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

}
