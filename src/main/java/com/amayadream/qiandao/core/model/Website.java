package com.amayadream.qiandao.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 网站实体
 * @author :  Amayadream
 * @date :  2017.03.15 11:07
 */
public class Website implements Serializable {

    /** 网站id */
    private String webId;
    /** 网站URL */
    private String webUrl;
    /** 网站名称 */
    private String webName;
    /** 网站描述/备注 */
    private String webDesc;
    /** 签到类 */
    private String className;
    /** 网站签到所需参数, JSON格式 */
    private String webParams;
    /** 创建时间 */
    private Date createdTime;
    /** 最后更新时间 */
    private Date updatedTime;
    /** 最后成功时间 */
    private Date successTime;

    public Website() {

    }

    public Website(String webId, String webUrl, String webName, String webDesc, String className, String webParams, Date createdTime, Date updatedTime, Date successTime) {
        this.webId = webId;
        this.webUrl = webUrl;
        this.webName = webName;
        this.webDesc = webDesc;
        this.className = className;
        this.webParams = webParams;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.successTime = successTime;
    }

    public String getWebId() {
        return webId;
    }

    public void setWebId(String webId) {
        this.webId = webId;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getWebDesc() {
        return webDesc;
    }

    public void setWebDesc(String webDesc) {
        this.webDesc = webDesc;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getWebParams() {
        return webParams;
    }

    public void setWebParams(String webParams) {
        this.webParams = webParams;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }
}
