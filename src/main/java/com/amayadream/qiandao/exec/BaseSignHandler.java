package com.amayadream.qiandao.exec;

import com.alibaba.fastjson.JSONObject;

/**
 * 基础签到插件接口
 * @author :  Amayadream
 * @date :  2017.03.15 14:26
 */
public interface BaseSignHandler {

    void before();

    void sign(JSONObject object);

    void after();

}
