package com.yidiandian;

import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author 凤凰小哥哥
 * @date 2020-12-20
 */
@Component
@Slf4j
public class putTest extends SpringResttemplateApplicationTests{

    private String baseUrl = "http://localhost:8002/brand";

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testPut(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","waitforyouforEnd");
        jsonObject.put("image","http://www.baidu.com.jpg.jif");
        jsonObject.put("letter","Q");
        jsonObject.put("seq",155);

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject,httpHeaders);

        String url = baseUrl+"/{id}";
        restTemplate.put(url, httpEntity, 325414);
    }

}
