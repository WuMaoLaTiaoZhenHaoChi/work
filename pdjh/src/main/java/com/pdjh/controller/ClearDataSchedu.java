package com.pdjh.controller;

import com.pdjh.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author: duant
 * @Date: 2020/4/23 21:48
 * @Description:
 */
@Slf4j
@Component
public class ClearDataSchedu {


    @Autowired
    private OrderMapper orderMapper;

    //每天0点执行
    @Scheduled(cron="0 0 0 * * ? ")
//    @Scheduled(cron="5/5 * * * * ?")
    public void clearData(){
        int i = 0;
        log.info(" -----开始清空无用数据----- ");
        i = orderMapper.clearData();
        log.info(" -----清空无用数据结束，已清除" + i + "条无用数据----- ");
    }

}
