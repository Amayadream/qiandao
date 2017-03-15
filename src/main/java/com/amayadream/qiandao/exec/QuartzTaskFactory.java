package com.amayadream.qiandao.exec;


import com.amayadream.qiandao.core.model.Task;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Task执行工厂
 * @author :  Amayadream
 * @date :  2017.03.15 14:09
 */
public class QuartzTaskFactory implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        Task task = (Task) context.getMergedJobDataMap().get("scheduleJob");
        //TODO 指定任务
    }

}
