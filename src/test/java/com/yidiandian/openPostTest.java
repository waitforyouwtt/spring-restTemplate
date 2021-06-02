package com.yidiandian;

import cn.hutool.json.JSONUtil;
import com.cas.starter.configuration.SignatureUtils;
import com.yidiandian.view.ProductAuthMultiUserVo;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class openPostTest extends SpringResttemplateApplicationTests {

    String sitBaseUrl = "http://o2o-port-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open";
    String devBaseUrl = "http://o2o-port-dev.o2o-support-idaas-gateway.devgw.yonghui.cn/o2o-support-idaas-application/v1/open";

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void post1(){
/*        Map<String, String> map = new HashMap<>();
        map.put("productCode","kfpt-cs");
        map.put("roleCode","kfpt-cs00000001");
        String url = sitBaseUrl + "/role/findRoleList";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(map));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, map, "HTTP/1.1", url, "", ""));
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));*/
    }

    @Test
    public void testDemo9() {
        String url = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open/role/RoleAuthorizationUser";
        List<ProductAuthMultiUserVo> list = new ArrayList<>();
        ProductAuthMultiUserVo vo = new ProductAuthMultiUserVo();
        vo.setProductCode("sjcas");
        vo.setRoleCode("kfpt-cs00000000");
        vo.setUserCode("80996804");
        vo.setOptCode("80996804");
        vo.setOptBy("xx");

        vo.setOrganizationCode("kfpt-cs000000");
        vo.setProductCode("sjcas");
        vo.setOrganizationCode("sjcas000001");
        vo.setUserCode("80929954");
        vo.setRoleCode("kfpt-cs00000000");
        vo.setOptCode("80996804");
        vo.setOptBy("xx");
        list.add(vo);

        HttpHeaders header = new HttpHeaders();
        header.set("productCode","sjcas");
        header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Date", SignatureUtils.toGMTString(new Date()));
        header.set("Digest", SignatureUtils.generateDigestString(list));
        header.set("Authorization", SignatureUtils.generateAuthorization(HttpMethod.POST, JSONUtil.toJsonStr(list), "HTTP/1.1", url,  "sjcas", "BgPYDBeely1pcsag",new Date()));
        HttpEntity<List<ProductAuthMultiUserVo>> httpEntity = new HttpEntity<>(list, header);
        ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);
        log.info("获取到的结果:{}", JSONUtil.toJsonStr(resp.getBody()));
    }

    @Test
    public void test10(){
        String url = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/" +
                "o2o-support-idaas-application/v1/open/role/RoleAuthorizationUser";

        List<ProductAuthMultiUserVo> list = new ArrayList<>();
        ProductAuthMultiUserVo vo = new ProductAuthMultiUserVo();
        vo.setProductCode("sjcas");
        vo.setRoleCode("kfpt-cs00000000");
        vo.setUserCode("80996804");
        vo.setOptCode("80996804");
        vo.setOptBy("xx");

        vo.setOrganizationCode("kfpt-cs000000");
        vo.setProductCode("sjcas");
        vo.setOrganizationCode("sjcas000001");
        vo.setUserCode("80929954");
        vo.setRoleCode("kfpt-cs00000000");
        vo.setOptCode("80996804");
        vo.setOptBy("xx");
        list.add(vo);

        HttpHeaders header = SignatureUtils.generateHeaders(HttpMethod.POST, list, "HTTP/1.1",
                url, "sjcas", "BgPYDBeely1pcsag");// BgPYDBeely1pcsag sjcas

        HttpEntity<Map<String,List<ProductAuthMultiUserVo>>> httpEntity = new HttpEntity(list, header);
        try {
            ResponseEntity<String> resKongDTO = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
            System.out.println(resKongDTO.getBody());
        } catch (Exception e) {
            System.out.println("Authorization:"+header.get("Authorization"));
            System.out.println("Date:"+header.get("Date"));
            System.out.println("Digest:"+header.get("Digest"));
            e.printStackTrace();
        }
    }

}
