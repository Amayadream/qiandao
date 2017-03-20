package com.amayadream.qiandao.web.exception;

/**
 * 越权操作, 主要是注册用户对管理员才能进行的操作进行访问
 * @author :  Amayadream
 * @date :  2016.10.07 01:01
 */
public class BeyondPermissionException extends Exception {

    public BeyondPermissionException(String message) {
        super(message);
    }

    public BeyondPermissionException() {
        super("对不起, 您的操作超出您的权限范围, 此次越权已被记录!");
    }

}
