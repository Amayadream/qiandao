package com.amayadream.qiandao.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author :  Amayadream
 * @date :  2017.04.12 21:13
 */
public class ResultEntity {

    private Integer code;
    private String message;
    private Date timestamp;
    private Serializable data;

    private ResultEntity(Integer code, String message, Date timestamp, Serializable data) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.data = data;
    }

    public static ResultEntity buildOkResult(Integer code, String message) {
        return new ResultEntity(code, message, new Date(), null);
    }

    public static ResultEntity buildOkResult(Integer code, String message, Serializable data) {
        return new ResultEntity(code, message, new Date(), data);
    }

    public static ResultEntity buildNokResult(Integer code, String message) {
        return new ResultEntity(code, message, new Date(), null);
    }

    public static ResultEntity buildNokResult(Integer code, String message, Serializable data) {
        return new ResultEntity(code, message, new Date(), data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }
}
