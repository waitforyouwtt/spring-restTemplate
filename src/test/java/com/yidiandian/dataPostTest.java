package com.yidiandian;

import cn.hutool.json.JSONUtil;
import com.cas.starter.configuration.SignatureUtils;
import com.yidiandian.utils.MapUtils;
import com.yidiandian.view.MultiResourceAuthRoleVO;
import com.yidiandian.view.ReqUserDataAuthVO;
import com.yidiandian.view.RoleAuthorizationUserVO;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class dataPostTest extends SpringResttemplateApplicationTests {

    String sitBaseUrl = "http://o2o-port-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open";
    String devBaseUrl = "http://o2o-port-dev.o2o-support-idaas-gateway.devgw.yonghui.cn/o2o-support-idaas-application/v1/open";

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void post00(){
        String url = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-cas-adapter/v1/upm/up/auth/code";

        Map<String, String> map = new HashMap<>();

        //TGT-677-M7RmMOFQJZHceE-4FuyCqYltHTT-UR8trf4l-OaHC9x4Xi0VCh2t-kngqLVJERZpgdwo2o-support-idaas-cas-8b88b-5d9945564c-q7bp5
        map.put("username","80663909");
        map.put("password","1234qwer");

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(map));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, JSONUtil.toJsonStr(map), "HTTP/1.1", url, "yhglkfts", "7CVwNEPkKptU7IlH",null));
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }

    @Test
    public void post0(){
        String url = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-cas-adapter/v1/upm/up/auth/accessToken";

        Map<String, String> map = new HashMap<>();

        map.put("code","TGT-677-M7RmMOFQJZHceE-4FuyCqYltHTT-UR8trf4l-OaHC9x4Xi0VCh2t-kngqLVJERZpgdwo2o-support-idaas-cas-8b88b-5d9945564c-q7bp5");
        map.put("service","http://sit.usercenter.sitapis.yonghui.cn");

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(map));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, JSONUtil.toJsonStr(map), "HTTP/1.1", url, "yhglkfts", "7CVwNEPkKptU7IlH",null));
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }

    @Test
    public void post01(){
        String url = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-cas-adapter/v1/upm/up/auth/code";

        Map<String, String> map = new HashMap<>();

        map.put("username","81084193");
        map.put("password","1234qwer");

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(map));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, JSONUtil.toJsonStr(map), "HTTP/1.1", url, "yhglkfts", "7CVwNEPkKptU7IlH",null));
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }

    @Test
    public void post1(){
        String url = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-cas-adapter/v1/upm/up/auth";

        Map<String, String> map = new HashMap<>();

        map.put("username","81084193");
        map.put("password","1234qwer");

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(map));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, JSONUtil.toJsonStr(map), "HTTP/1.1", url, "yhglkfts", "7CVwNEPkKptU7IlH",null));
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }

    @Test
    public void postxx(){
        String url = "http://shenshu-api.yonghui.cn//o2o-support-idaas-application/v1/open/data/rule/user";

        Map<String,String> map = new HashMap<>();
        map.put("userCode","81050124");
        map.put("ruleCode","yangchuanyunlan");
        map.put("productCode","xposr");

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(map));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, JSONUtil.toJsonStr(map), "HTTP/1.1", url, "xposr", "E1N1ph4Hg8FlRCes",null));
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }

    @Test
    public void post2(){
        List<RoleAuthorizationUserVO> list = new ArrayList<>();
        RoleAuthorizationUserVO vo = new RoleAuthorizationUserVO();
        vo.setProductCode("sjcas");
        vo.setOrganizationCode("sjcas000001");
        vo.setUserCode("80900867");
        vo.setRoleCode("sjcas0000000t");
        vo.setOptCode("1001");
        vo.setOptBy("云澜");

        RoleAuthorizationUserVO vo1 = new RoleAuthorizationUserVO();
        vo1.setProductCode("sjcas");
        vo1.setOrganizationCode("sjcas000001");
        vo1.setUserCode("81041592");
        vo1.setRoleCode("sjcas0000000t");
        vo1.setOptCode("1001");
        vo1.setOptBy("云澜");
        list.add(vo);
        list.add(vo1);

        String url = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open/role/RoleAuthorizationUser";

        HttpHeaders header = new HttpHeaders();
        header.set("productCode","sjcas");
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(list));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, JSONUtil.toJsonStr(list), "HTTP/1.1", url, "sjcas", "BgPYDBeely1pcsag",null));
        HttpEntity<List<RoleAuthorizationUserVO>> httpEntity = new HttpEntity<>(list, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }

    @Test
    public void test3(){
        String s = MapUtils.fyFormatDate();
        log.info("生成的时间：{}",s);
    }


    @Test
    public void test5(){
        /*Map<String, String> map = new HashMap<>();
        map.put("productCode", "sjcas");
        map.put("organizationCode", "sjcas000001");
        map.put("roleCode", "sjcas0000000o");
        String url = sitBaseUrl + "/role/getRoleAuthUser";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(map));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, map, "HTTP/1.1", url, "", ""));
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));*/
    }
}
