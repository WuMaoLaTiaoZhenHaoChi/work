package com.pdjh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pdjh.entity.EmployeeInfo;
import com.pdjh.mapper.EmployeeMapper;
import com.pdjh.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @Author: duant
 * @Date: 2020/3/29 10:46
 * @Description:
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeeInfo> implements EmployeeService {

}
