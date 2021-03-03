package com.yidiandian;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.yidiandian.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author 凤凰小哥哥
 * @date 2020-12-20
 */
@Component
@Slf4j
public class postTest extends SpringResttemplateApplicationTests{

    @Autowired
    RestTemplate restTemplate;

    private String baseUrl = "http://localhost:8002/brand";

    @Test
    public void testPost(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","waitforyou");
        jsonObject.put("image","http://www.baidu.com.jpg");
        jsonObject.put("letter","W");
        jsonObject.put("seq",15);

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject,httpHeaders);

        String url = baseUrl+"/save";
        ResponseEntity<String> result = restTemplate.postForEntity(url, httpEntity, String.class);
        log.info("获取到的结果是:{}", JSONUtil.toJsonStr(result));
    }

    @Test
    public void transferKong(){

        String clientId = "beautiful";
        String clientSecret = "beautiful012";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", clientId);
        jsonObject.put("secret",clientSecret);

        //调用kong 网关
        String url = Constant.KONG_URL_PRE+clientId+Constant.KONG_URL_END_SAVE;
        log.info("调用kong的url:{}",url);

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject,httpHeaders);

        ResponseEntity<String> result = restTemplate.postForEntity(url, httpEntity, String.class);
        log.info("获取到的结果是:{}", JSONUtil.toJsonStr(result.getBody()));
        Map<String,String> map = (Map<String, String>) JSON.parse(result.getBody());
        log.info("map:{}",map.get("code"));
    }

    @Test
    public void transferKong2(){
        String clientId = "beautiful";
        String clientSecret = "beautiful012";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", clientId);
        jsonObject.put("secret",clientSecret);

        //调用kong 网关
        String url = Constant.KONG_URL_PRE+clientId+"/"+clientId+Constant.KONG_URL_END_DELETE;
        log.info("调用kong的url:{}",url);

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject,httpHeaders);

        ResponseEntity<String> result = restTemplate.postForEntity(url, httpEntity, String.class);
        log.info("获取到的结果是:{}", JSONUtil.toJsonStr(result.getBody()));
        Map<String,String> map = (Map<String, String>) JSON.parse(result.getBody());
        log.info("map:{}",map.get("code"));
    }

}
