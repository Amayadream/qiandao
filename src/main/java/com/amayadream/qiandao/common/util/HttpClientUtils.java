package com.amayadream.qiandao.common.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

/**
 * httpclient工具类
 * @author :  Amayadream
 * @date :  2017.04.19 21:39
 */
public class HttpClientUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    public static final String CHARSET_UTF8 = "utf-8";
    private static  Header[] HTTP_COMMON_HEADER = {
            new BasicHeader(HttpHeaders.ACCEPT, "*/*"),
            new BasicHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36"),
            new BasicHeader(HttpHeaders.CONNECTION, "keep-alive"),
            new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate"),
            new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.8"),
    };
    private static final RequestConfig HTTP_REQUEST_CONFIG = RequestConfig.custom()
            .setConnectTimeout(5000)
            .setSocketTimeout(5000)
            .setConnectionRequestTimeout(5000)
            .build();

    public static String getRequest(String url) {
        return getRequest(url, null);
    }

    public static String getRequest(String url, Header[] headers) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        get.setConfig(HTTP_REQUEST_CONFIG);
        get.setHeaders(HTTP_COMMON_HEADER);
        if (headers != null && headers.length > 0) {
            get.setHeaders(ArrayUtils.addAll(HTTP_COMMON_HEADER, headers));
        }
        try {
            HttpResponse response = client.execute(get);
            if (Arrays.asList(200, 302).contains(response.getStatusLine().getStatusCode())) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, CHARSET_UTF8);
            }
            logger.warn("请求发生错误, 状态码: {}", response.getStatusLine().getStatusCode());
            return null;
        } catch (IOException e) {
            logger.error("请求失败, 错误原因: {}", e.getMessage());
            return null;
        }
    }

    public static String postRequest(String url, HttpEntity param) {
        return postRequest(url, param, null);
    }

    public static String postRequest(String url, HttpEntity param, Header[] headers) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setConfig(HTTP_REQUEST_CONFIG);
        post.setHeaders(HTTP_COMMON_HEADER);
        if (headers != null && headers.length > 0) {
            post.setHeaders(ArrayUtils.addAll(HTTP_COMMON_HEADER, headers));
        }
        post.setEntity(param);
        try {
            HttpResponse response = client.execute(post);
            if (Arrays.asList(200, 302).contains(response.getStatusLine().getStatusCode())) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, CHARSET_UTF8);
            }
            logger.warn("请求发生错误, 状态码: {}", response.getStatusLine().getStatusCode());
            return null;
        } catch (IOException e) {
            logger.error("请求失败, 错误原因: {}", e.getMessage());
            return null;
        }
    }

}
