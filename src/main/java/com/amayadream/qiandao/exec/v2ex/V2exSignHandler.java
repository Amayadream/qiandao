package com.amayadream.qiandao.exec.v2ex;

import com.alibaba.fastjson.JSONObject;
import com.amayadream.qiandao.exec.BaseSignHandler;
import org.springframework.stereotype.Component;

/**
 * @author :  Amayadream
 * @date :  2017.03.15 14:31
 */
@Component
public class V2exSignHandler implements BaseSignHandler {

    @Override
    public void before() {
        System.out.println("before");
    }

    @Override
    public void sign(JSONObject object) {
        System.out.println("sign");
    }

    @Override
    public void after() {
        System.out.println("after");
    }

}
