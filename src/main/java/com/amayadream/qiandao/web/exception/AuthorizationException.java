package com.amayadream.qiandao.web.exception;

/**
 * 认证失败异常处理
 * @author :  Amayadream
 * @date :  2016.08.12 22:02
 */
public class AuthorizationException extends Exception {

    public AuthorizationException() {

    }

    public AuthorizationException(String message) {
        super(message);
    }

}
