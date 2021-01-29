package com.yidiandian;

import cn.hutool.json.JSONUtil;
import com.cas.starter.configuration.SignatureUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
@Slf4j
public class dataPostTest extends SpringResttemplateApplicationTests {

    String sitBaseUrl = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open";
    String devBaseUrl = "http://o2o-support-dev.o2o-support-idaas-gateway.devgw.yonghui.cn/o2o-support-idaas-application/v1/open";

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void post1(){
        Map<String, String> map = new HashMap<>();
        map.put("productCode","sjcas");
        String url = sitBaseUrl + "/role/findOrganizationRolePage";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(map));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, map, "HTTP/1.1", url, "sjcas", "BgPYDBeely1pcsag"));
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }

    @Test
    public void post2(){
        List<RoleAuthorizationUserVO> list = new ArrayList<>();
        RoleAuthorizationUserVO vo = new RoleAuthorizationUserVO();
        vo.setOrganizationCode("sjcas000001");
        vo.setUserCode("80929954");
        vo.setRoleCode("sjcas0000000o");
        vo.setOptCode("1001");
        vo.setOptBy("1001");
        list.add(vo);

        String url = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open/role/RoleAuthorizationUser";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(list));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, list, "HTTP/1.1", url, "sjcas", "BgPYDBeely1pcsag"));
        HttpEntity<List<RoleAuthorizationUserVO>> httpEntity = new HttpEntity<>(list, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }

    @Test
    public void test3(){
        String s = MapUtils.randomUUID();
        log.info("生成的时间：{}",s);
    }

    @Test
    public void test4(){

        MultiResourceAuthRoleVO vo = new MultiResourceAuthRoleVO();
        vo.setProductCode("sjcas");
        vo.setResourceCodes(Arrays.asList("datawork"));
        vo.setRoleCode("sjcas00000000");
        vo.setTenantCode("sjcas");
        vo.setOptBy("0000");
        vo.setOptCode("0000");

        String url = sitBaseUrl + "/resource/resourceAuthRole";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(vo));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, vo, "HTTP/1.1", url, "sjcas", "BgPYDBeely1pcsag"));
        HttpEntity<MultiResourceAuthRoleVO> httpEntity = new HttpEntity<>(vo, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }

    @Test
    public void test5(){
        Map<String, String> map = new HashMap<>();
        map.put("productCode", "sjcas");
        map.put("organizationCode", "sjcas000001");
        map.put("roleCode", "sjcas0000000o");
        String url = sitBaseUrl + "/role/getRoleAuthUser";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(map));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, map, "HTTP/1.1", url, "sjcas", "BgPYDBeely1pcsag"));
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }
}
