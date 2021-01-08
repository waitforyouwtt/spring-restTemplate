package com.yidiandian;

import cn.hutool.json.JSONUtil;
import com.cas.starter.configuration.SignatureUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 凤凰小哥哥
 * @date 2020-12-20
 */
@Component
@Slf4j
public class ProjectTestDev extends SpringResttemplateApplicationTests{

    String sitBaseUrl = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open";
    String devBaseUrl = "http://o2o-support-dev.o2o-support-idaas-gateway.devgw.yonghui.cn/o2o-support-idaas-application/v1/open";


    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testGetForHeader0(){
        String url = devBaseUrl+"/product/getAuthOrganization?productCode=jcsj20201127&pageNum=1&pageSize=100";

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "jcsj20201127", "RsOyuJsSgJM7Xe77"));

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(header);

        ResponseEntity resKongDTO = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        log.info("返回的结果：{}", JSONUtil.toJsonStr(resKongDTO.getBody()));
    }

    @Test
    public void testGetForHeader(){
        Map<String,String> map = new HashMap<>();
        map.put("productCode","jcsj20201127");
        map.put("userCode","80838245");
        //不支持中文
        /*map.put("realName","王建伟");*/
        map.put("pageNum","1");
        map.put("pageSize","10");
        String url = devBaseUrl+"/product/getAuthUser?"+MapUtils.getStringByMap(map);

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "jcsj20201127", "RsOyuJsSgJM7Xe77"));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}",JSONUtil.toJsonStr(result));
    }


    @Test
    public void testPostForHeader0(){
        Map<String, String> map = new HashMap<>();
        map.put("productCode","jcsj20201127");
        map.put("parentCode","80838245");
        map.put("resourceCode","10056");
        map.put("resourceName","yunlan哥哥");
        map.put("type","1");
        map.put("orderNum","10");
        map.put("description","我是凤凰小哥哥");
        map.put("path","1001/1002/1003");
        map.put("optCode","1001");
        map.put("optBy","澜哥哥");

        String url = devBaseUrl +"/resource/add";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(map));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, map, "HTTP/1.1", url, "jcsj20201127", "RsOyuJsSgJM7Xe77"));
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}",JSONUtil.toJsonStr(resp));
    }

}
