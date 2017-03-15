package com.amayadream.qiandao.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 签到任务
 * @author :  Amayadream
 * @date :  2017.03.15 13:52
 */
public class Task implements Serializable {

    /** 任务名称(对应webId) */
    private String taskName;
    /** 任务分组(对应email) */
    private String taskGroup;
    /** 任务时间表达式 */
    private String taskCronExp;
    /** 任务类 */
    private String taskClass;
    /** 任务所需数据, JSON格式 */
    private String taskData;
    /** 任务状态, 1:正常, -1:暂停 */
    private int taskStatus;
    /** 任务创建时间 */
    private Date createdTime;
    /** 最后成功执行时间 */
    private Date successTime;



    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup;
    }

    public String getTaskCronExp() {
        return taskCronExp;
    }

    public void setTaskCronExp(String taskCronExp) {
        this.taskCronExp = taskCronExp;
    }

    public String getTaskClass() {
        return taskClass;
    }

    public void setTaskClass(String taskClass) {
        this.taskClass = taskClass;
    }

    public String getTaskData() {
        return taskData;
    }

    public void setTaskData(String taskData) {
        this.taskData = taskData;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }
}
