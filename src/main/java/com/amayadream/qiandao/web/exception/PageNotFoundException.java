package com.amayadream.qiandao.web.exception;

/**
 * 404 Not Found
 * @author :  Amayadream
 * @date :  2016.08.25 21:43
 */
public class PageNotFoundException extends Exception {

    public PageNotFoundException() {

    }

    public PageNotFoundException(String message) {
        super(message);
    }

}
