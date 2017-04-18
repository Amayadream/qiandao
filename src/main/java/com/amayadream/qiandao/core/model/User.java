package com.amayadream.qiandao.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :  Amayadream
 * @date :  2017.03.15 11:34
 */
public class User implements Serializable {

    /** 用户邮箱 */
    private String email;
    /** 用户密码 */
    private String password;
    /** 盐 */
    private String salt;
    /** 用户角色 */
    private String role;
    /** 创建时间 */
    private Date createdTime;
    /** 最后登录时间 */
    private Date lastLoginTime;
    /** 用户状态, 1:正常, -1:待验证邮箱, -2:禁用 */
    private int status;

    public User() {

    }

    public User(String email, String password, String salt, String role, Date createdTime, Date lastLoginTime, int status) {
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.role = role;
        this.createdTime = createdTime;
        this.lastLoginTime = lastLoginTime;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
