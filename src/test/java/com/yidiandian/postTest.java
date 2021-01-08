package com.yidiandian;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

}
