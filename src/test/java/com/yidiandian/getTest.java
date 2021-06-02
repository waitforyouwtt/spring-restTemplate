package com.yidiandian;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yidiandian.utils.MapUtils;
import com.yidiandian.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void getForObjectTest2(){
        //get 请求的六种方法总结：
        Map<String,String> map = new HashMap<>();
        map.put("userInfoId","1,2");
        String url = "http://localhost:8080/v1/purchase/queryUserBaseByParams"+"?"+ MapUtils.getStringByMap(map);
        //请求地址 & 返回类型 & 参数
        Result method1 = restTemplate.getForObject(url, Result.class);
        log.info("method1获取到的结果:{}",method1);
    }

    @Test
    public void wt(){
        //get 请求的六种方法总结：
        Map<String,String> map = new HashMap<>();
        map.put("productCode","2");
        String url = "http://localhost:8080/v1/purchase/queryUserBaseByParams"+"?"+ MapUtils.getStringByMap(map);

    }

}
