package com.yidiandian;

import cn.hutool.json.JSONUtil;
import com.cas.starter.configuration.SignatureUtils;
import com.yidiandian.utils.MapUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class dataGetTest extends SpringResttemplateApplicationTests {

    String sitBaseUrl = "http://o2o-sort-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open";
    String devBaseUrl = "http://o2o-sort-dev.o2o-support-idaas-gateway.devgw.yonghui.cn/o2o-support-idaas-application/v1/open";

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void test1(){
        Map<String,String> map = new HashMap<>();
        map.put("productCode","jcsj20201127");
        map.put("userCode","80838245");
        //不支持中文
        /*map.put("realName","王建伟");*/
        map.put("pageNum","1");
        map.put("pageSize","10");
        String url = devBaseUrl+"/product/getAuthUser?"+ MapUtils.getStringByMap(map);

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "", ""));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));
    }

    @Test
    public void test2(){
        Map<String,String> map = new HashMap<>();
        map.put("productCode","sjcas");
       /* map.put("userCode","80838245");*/
        //不支持中文
        /*map.put("realName","王建伟");*/
        map.put("pageNum","1");
        map.put("pageSize","10");
        String url = sitBaseUrl+"/product/getAuthUser?"+MapUtils.getStringByMap(map);

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "", ""));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));
    }

    @Test
    public void test3(){
        Map<String,String> map = new HashMap<>();
        map.put("productCode","sjcas");
         map.put("roleCode","sjcas00000008");
        //不支持中文
        /*map.put("realName","王建伟");*/
        map.put("pageNum","1");
        map.put("pageSize","10");
        String url = sitBaseUrl+"/role/getRoleResourcePage?"+MapUtils.getStringByMap(map);

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "", ""));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));
    }




}
