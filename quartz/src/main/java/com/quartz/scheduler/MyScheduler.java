package com.quartz.scheduler;

import com.quartz.job.PrintWordsJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: duant
 * @Date: 2020/10/27 9:51
 * @Description:
 */
public class MyScheduler {


    public static void main(String[] args) throws SchedulerException, InterruptedException {

        // 1、创建调度器Scheduler
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();

        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("job", "这个Job用来测试的")
                .build();

        Date startDate = new Date();
        startDate.setTime(startDate.getTime() + 5000);

        Date endDate = new Date();
        endDate.setTime(startDate.getTime() + 5000);

        // 3、构建Trigger实例,每隔1s执行一次
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "triggerGroup1")
                .usingJobData("trigger", "这是jobDetail1的trigger")
                .startNow()
                .startAt(startDate)
                .endAt(endDate)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)   //每隔一秒执行一次
                        .repeatForever())           //一直执行
                .build();

        //4、执行
        Date date = scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("--------scheduler start ! ------------");
        scheduler.start();

        //睡眠
        TimeUnit.MINUTES.sleep(2);
        scheduler.shutdown();
        System.out.println("--------scheduler shutdown ! ------------");

    }

}
