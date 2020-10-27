package com.quartz.service;

/**
 * @Author: duant
 * @Date: 2020/10/27 14:31
 * @Description:
 */
public interface QuartzService {

    /**
     * 新增一个定时任务
     * @param objClass 执行任务类
     * @param jName 任务名称
     * @param jGroup 任务组
     * @param tName 触发器名称
     * @param tGroup 触发器组
     * @param cron cron表达式
     */
    void addJob(Class objClass,String jName, String jGroup, String tName, String tGroup, String cron);

    /**
     * 暂停定时任务
     * @param jName 任务名
     * @param jGroup 任务组
     */
    void pauseJob(String jName, String jGroup);

    /**
     * 继续定时任务
     * @param jName 任务名
     * @param jGroup 任务组
     */
    void resumeJob(String jName, String jGroup);

    /**
     * 删除定时任务
     * @param jName 任务名
     * @param jGroup 任务组
     */
    void deleteJob(String jName, String jGroup);


}
