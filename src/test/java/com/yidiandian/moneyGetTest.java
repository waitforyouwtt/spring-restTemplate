package com.yidiandian;

import cn.hutool.json.JSONUtil;
import com.cas.starter.configuration.SignatureUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class moneyGetTest extends SpringResttemplateApplicationTests {

    String sitBaseUrl = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open";
    String devBaseUrl = "http://o2o-support-dev.o2o-support-idaas-gateway.devgw.yonghui.cn/o2o-support-idaas-application/v1/open";

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
        String url = devBaseUrl+"/product/getAuthUser?"+MapUtils.getStringByMap(map);

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "jcsj20201127", "RsOyuJsSgJM7Xe77"));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));
    }

    @Test
    public void test2(){

        Map<String,String> map = new HashMap<>();
        map.put("productCode","cwzt");
        map.put("userCode","80728143");

        map.put("pageNum","1");
        map.put("pageSize","10");
        String url = sitBaseUrl+"/resource/queryResourceAuthUser?"+MapUtils.getStringByMap(map);

        HttpHeaders header = new HttpHeaders();
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.GET, null, "HTTP/1.1", url, "cwzt", "3ASyxs0lbXeNebCR"));

        HttpEntity<String> httpEntity = new HttpEntity<>(header);

        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
// users.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(UserInfo :: getResourceCode))), ArrayList::new));
        log.info("获取到的结果:{}", JSONUtil.toJsonStr(result.getBody()));
    }

    @Test
    public void test3(){
        List<UserInfo> users = new ArrayList<>();
        users.add(new UserInfo("80728143","cwzt00000004","/notice_list","历史公告","/notice_list"));
        users.add(new UserInfo("80728143","cwzt00000004","caiwu","财务中心","/caiwu"));
        users.add(new UserInfo("80728143","cwzt00000004","/publish_notice1","发布公告","/publish_notice"));
        users.add(new UserInfo("80728143","cwzt00000004","/shezhi","系统设置","/设置"));
        users.add(new UserInfo("80728143","cwzt00000004","/shouye","首页","/home"));
        users.add(new UserInfo("80728143","cwzt00000004","/shuiwu","税务中心","/shuiwu"));
        users.add(new UserInfo("80728143","cwzt00000004","/zijin","资金中心","/zijin"));
        users.add(new UserInfo("80728143","cwzt00000005","/notice_list","历史公告","/notice_list"));
        users.add(new UserInfo("80728143","cwzt00000005","/caiwu","财务中心","/notice_list"));
        users.add(new UserInfo("80728143","cwzt00000005","/publish_notice1","发布公告","/publish_notice"));
        //log.info("原始数据：{}",JSONUtil.toJsonStr(users));
        log.info("原始数据的size:{}",users.size());
        //我是去重处理哦
        users = users.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(UserInfo:: getResourceCode))), ArrayList::new));
        log.info("处理后的数据：{}",JSONUtil.toJsonStr(users));
        log.info("处理收数据的size:{}",users.size());
    }
}
