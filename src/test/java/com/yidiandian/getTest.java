package com.yidiandian;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author 凤凰小哥哥
 * @date 2020-12-20
 */
@Component
@Slf4j
public class getTest extends SpringResttemplateApplicationTests{

    @Autowired
    RestTemplate restTemplate;

    private String baseUrl = "http://localhost:8002/brand";

    /**
     * 获取无参数的get请求
     */
    @Test
    public void testGETNoParams(){
        String result = restTemplate.getForObject(baseUrl+"/findAll", String.class);
        log.info("获取到的结果是:{}", JSONUtil.toJsonStr(result));
    }
    /**
     * 获取有参数的get请求
     */

    @Test
    public void testGETWithParams(){
        String result = restTemplate.getForObject(baseUrl+"/{id}", String.class,"1115");
        log.info("获取到的结果是:{}", JSONUtil.toJsonStr(result));
    }

    @Test
    public void getForObjectTest(){
        //get 请求的六种方法总结：

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","waitforyou");
        jsonObject.put("id",1115);
        //请求地址 & 返回类型 & 参数
        Result method1 = restTemplate.getForObject(baseUrl + "/{id}", Result.class, jsonObject);
        log.info("method1获取到的结果:{}",method1);

        Result method2 = restTemplate.getForObject(baseUrl + "/1115", Result.class);
        log.info("method2获取到的结果:{}",method2);

        ResponseEntity<Result> method3 = restTemplate.getForEntity(baseUrl + "/1115", Result.class);
        log.info("method3获取到的结果:{}",method3);

        ResponseEntity<Result> method4 = restTemplate.getForEntity(baseUrl + "/{id}", Result.class, jsonObject);
        log.info("method4获取到的结果:{}",method4);
    }

}
