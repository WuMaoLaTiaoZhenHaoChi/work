package com.quartz.scheduler;

import com.quartz.job.PrintWordsJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @Author: duant
 * @Date: 2020/10/27 11:05
 * @Description:
 */
public class MyScheduler2 {

    public static void main(String[] args) throws SchedulerException {
        // 1、创建调度器Scheduler
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();

        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
                .withIdentity("job2", "group2")
                .usingJobData("job", "这个Job用来测试的")
                .build();

        // 3、构建Trigger实例,每隔1s执行一次
        Date startDate = new Date();
        startDate.setTime(startDate.getTime() + 5000);

        Date endDate = new Date();
        endDate.setTime(startDate.getTime() + 5000);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "triggerGroup2")
                .usingJobData("trigger", "这是jobDetail1的trigger")
                .startNow()
                .startAt(startDate)
                .endAt(endDate)
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
                .build();

        //4、执行
        scheduler.scheduleJob(jobDetail,cronTrigger);
        System.out.println("--------scheduler start ! ------------");
        scheduler.start();
        System.out.println("--------scheduler shutdown ! ------------");

    }

}
