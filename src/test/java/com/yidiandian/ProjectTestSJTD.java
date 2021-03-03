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

/**
 * @author 凤凰小哥哥
 * @date 2021-01-08
 */
@Component
@Slf4j
public class ProjectTestSJTD extends SpringResttemplateApplicationTests {

    String devBaseUrl = "http://o2o-port-dev.o2o-support-idaas-gateway.devgw.yonghui.cn/o2o-support-idaas-application/v1/open";


    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testGetForHeader0() {
        Map<String,String> map = new HashMap<>();
        map.put("productCode","sjztkf");
        map.put("userCode","80838245");
        //不支持中文
        /*map.put("realName","王建伟");*/
        map.put("path","01");
        map.put("resourceType","1");

        String url = devBaseUrl+"/resource/queryResourceAuth?"+ MapUtils.getStringByMap(map);

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "", ""));

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(header);

        ResponseEntity resKongDTO = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        log.info("返回的结果：{}", JSONUtil.toJsonStr(resKongDTO.getBody()));
    }

    @Test
    public void testGetForHeader11() {

        String url = "http://o2o-support-prod.o2o-support-idaas-gateway.gw.yonghui.cn/o2o-support-idaas-application/v1/open/product/getAuthUser?productCode=bgzt&pageSize=2147483647&pageNum=1";

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "", ""));

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(header);

        ResponseEntity resKongDTO = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        log.info("返回的结果：{}", JSONUtil.toJsonStr(resKongDTO.getBody()));
    }
}
