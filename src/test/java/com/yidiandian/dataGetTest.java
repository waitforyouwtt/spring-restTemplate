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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class dataGetTest extends SpringResttemplateApplicationTests {

    String sitBaseUrl = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open";
    String devBaseUrl = "http://o2o-support-dev.o2o-support-idaas-gateway.devgw.yonghui.cn/o2o-support-idaas-application/v1/open";
    String prodUrl = "http://shenshu-api.yonghui.cn/o2o-support-idaas-application/v1/open";

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testyangchuan(){
        Map<String,String> map = new HashMap<>();
       /* map.put("userCode","81050124");
        map.put("ruleCode","yangchuanyunlan");*/
        /*map.put("productCode","sjcas");
        map.put("pageSize","10");*/

        String url = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open/role/RoleAuthorizationUser";
        log.info("远程调用url:{}",url);

        HttpHeaders header = new HttpHeaders();
        header.set("productCode","sjcas");

        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(map));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, null, "HTTP/1.1", url, "sjcas", "BgPYDBeely1pcsag",null));
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }

    //http://shenshu-api.yonghui.cn/o2o-support-idaas-application/v1/open/role/findRoleByRoleCodes
    @Test
    public void test00(){
        Map<String,String> map = new HashMap<>();
        map.put("userCode","81050124");
        String url = "http://shenshu-api.yonghui.cn/o2o-support-idaas-application/v1/open/role/getRoleAuthUser";
        log.info("远程调用url:{}",url);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(map));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, map.toString(), "HTTP/1.1", url, "kfpt", "X2sBxDdK3MS2Ft77",null));
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }

    @Test
    public void test000(){
        Map<String,String> map = new HashMap<>();

        String url = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open/data/rule/role/auth/page";

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "sjcas", "BgPYDBeely1pcsag",null));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));
    }


    @Test
    public void test000t(){
        Map<String,String> map = new HashMap<>();

        String url = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-user/v1/open/organization/listAllByParent?parentCode=0";

        HttpHeaders header = new HttpHeaders();
        header.set("tenantCode","sjcas");
        header.set("productCode","bgzt");
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "bgzt", "YMeugiHOicQ7ZsIW",null));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));
    }

    @Test
    public void test0(){
        Map<String,String> map = new HashMap<>();
        map.put("productCode","jcsj20201127");
        map.put("userCode","80838245");

        map.put("pageNum","1");
        map.put("pageSize","10");
        String url = sitBaseUrl+"/product/getAuthUser?"+ MapUtils.getStringByMap(map);
        log.info("远程调用url:{}",url);
        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "yhdos", "VKLiQhd5CMkiOImo",null));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));
    }

    @Test
    public void test1(){
/*        Map<String,String> map = new HashMap<>();
        map.put("productCode","jcsj20201127");
        map.put("userCode","80838245");
        //不支持中文
        *//*map.put("realName","王建伟");*//*
        map.put("pageNum","1");
        map.put("pageSize","10");
        String url = devBaseUrl+"/product/getAuthUser?"+ MapUtils.getStringByMap(map);

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "", ""));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));*/
    }

    @Test
    public void test2(){
       /* Map<String,String> map = new HashMap<>();
        map.put("productCode","sjcas");
       *//* map.put("userCode","80838245");*//*
        //不支持中文
        *//*map.put("realName","王建伟");*//*
        map.put("pageNum","1");
        map.put("pageSize","10");
        String url = sitBaseUrl+"/product/getAuthUser?"+MapUtils.getStringByMap(map);

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "", ""));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));*/
    }

    @Test
    public void test3(){
/*        Map<String,String> map = new HashMap<>();
        map.put("productCode","sjcas");
         map.put("roleCode","sjcas00000008");
        //不支持中文
        *//*map.put("realName","王建伟");*//*
        map.put("pageNum","1");
        map.put("pageSize","10");
        String url = sitBaseUrl+"/role/getRoleResourcePage?"+MapUtils.getStringByMap(map);

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "", ""));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));*/
    }

    @Test
    public void test4(){
        /*Map<String,String> map = new HashMap<>();
       // map.put("productCode","sjztkf");
        map.put("userCode","80996801");

        String url = devBaseUrl+"/resource/queryResourceAuthUser?"+MapUtils.getStringByMap(map);

        HttpHeaders header = new HttpHeaders();
        header.set("tenantCode","sjztkf");
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "sjztkf", "qmzRUAjEblQis4Vk"));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));*/
    }


    @Test
    public void test5(){
        /*Map<String,String> map = new HashMap<>();
        // map.put("productCode","sjztkf");
        map.put("userCode","80996801");

        String url = "http://gateway.shenshu.yonghui.cn"+"/resource/queryResourceAuthUser?"+MapUtils.getStringByMap(map);

        HttpHeaders header = new HttpHeaders();
        header.set("tenantCode","sjztkf");
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "cwzt", "3ASyxs0lbXeNebCR"));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));*/
    }

}
