package com.amayadream.qiandao.exec.v2ex;

import com.alibaba.fastjson.JSONObject;
import com.amayadream.qiandao.common.util.HttpClientUtils;
import com.amayadream.qiandao.exec.BaseSignHandler;
import com.amayadream.qiandao.exec.exception.ParamsNotMatchException;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2017.03.15 14:31
 */
@Component
public class V2exSignHandler implements BaseSignHandler {

    private static String V2EX_LOGIN_URL = "https://www.v2ex.com/signin";
    private static String V2EX_MAIN_URL = "https://www.v2ex.com/";

    @Override
    public void before() {

    }


    @Test
    public void test() throws ParamsNotMatchException {
        JSONObject o = new JSONObject();
        o.put("username", "1");
        o.put("password", "1");
        sign(o);
    }

    /**
     * 1.[GET]访问https://www.v2ex.com/signin, 取得username/password/once
     * 2.[POST]访问https://www.v2ex.com/signin, 携带上三个参数
     * 3.[GET]访问https://www.v2ex.com/, 取得once
     * 4.
     * @param object
     * @throws ParamsNotMatchException
     */
    @Override
    public void sign(JSONObject object) throws ParamsNotMatchException {
        String username = object.getString("username");
        String password = object.getString("password");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            throw new ParamsNotMatchException();

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        //1.[GET]访问https://www.v2ex.com/signin, 取得username/password/once
        String str = HttpClientUtils.getRequest(V2EX_LOGIN_URL);
        Document doc = Jsoup.parse(str);
        List<Element> inputs = doc.getElementsByTag("input");
        for (Element input : inputs) {
            if (input.hasClass("sl")) { //用户名和密码框
                if ("password".equals(input.attr("type")))    //密码框
                    params.add(new BasicNameValuePair(input.attr("name"), username));
                else
                    params.add(new BasicNameValuePair(input.attr("name"), password));
            }
            if ("once".equals(input.attr("name")))
                params.add(new BasicNameValuePair("once", input.val()));
        }

        //2.[POST]访问https://www.v2ex.com/signin, 携带上三个参数
        try {
            HttpEntity entity = new UrlEncodedFormEntity(params, HttpClientUtils.CHARSET_UTF8);
            String result = HttpClientUtils.postRequest(V2EX_LOGIN_URL, entity);
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void after() {

    }

}
