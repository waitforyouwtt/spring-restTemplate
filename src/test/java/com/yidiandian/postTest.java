package com.yidiandian;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cas.starter.configuration.SignatureUtils;
import com.yidiandian.constant.ConstantPassword;
import com.yidiandian.constant.ConstantUrl;
import com.yidiandian.utils.MapUtils;
import com.yidiandian.utils.Result;
import com.yidiandian.utils.esay.RemoteCallUtils;
import com.yidiandian.view.IdaasRoleUsersDTO;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 凤凰小哥哥
 * @date 2020-12-20
 */
@Component
@Slf4j
public class postTest extends SpringResttemplateApplicationTests{

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RemoteCallUtils remoteCallUtils;

    private String baseUrl = "http://localhost:8002/brand";

    @Test
    public void testPost(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","waitforyou");
        jsonObject.put("image","http://www.baidu.com.jpg");
        jsonObject.put("letter","W");
        jsonObject.put("seq",15);

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject,httpHeaders);

        String url = baseUrl+"/save";
        ResponseEntity<String> result = restTemplate.postForEntity(url, httpEntity, String.class);
        log.info("获取到的结果是:{}", JSONUtil.toJsonStr(result));
    }

    @Test
    public void transferKong(){

        String clientId = "beautiful";
        String clientSecret = "beautiful012";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", clientId);
        jsonObject.put("secret",clientSecret);

        //调用kong 网关
        String url = ConstantUrl.KONG_URL_PRE+clientId+ ConstantUrl.KONG_URL_END_SAVE;
        log.info("调用kong的url:{}",url);

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject,httpHeaders);

        ResponseEntity<String> result = restTemplate.postForEntity(url, httpEntity, String.class);
        log.info("获取到的结果是:{}", JSONUtil.toJsonStr(result.getBody()));
       /* Map<String,String> map = (Map<String, String>) JSON.parse(result.getBody());
        log.info("map:{}",map.get("code"));*/
    }

    @Test
    public void transferKong2(){
        String clientId = "beautiful";
        String clientSecret = "beautiful012";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", clientId);
        jsonObject.put("secret",clientSecret);

        //调用kong 网关
        String url = ConstantUrl.KONG_URL_PRE+clientId+"/"+clientId+ ConstantUrl.KONG_URL_END_DELETE;
        log.info("调用kong的url:{}",url);

        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject,httpHeaders);

        ResponseEntity<String> result = restTemplate.postForEntity(url, httpEntity, String.class);
        log.info("获取到的结果是:{}", JSONUtil.toJsonStr(result.getBody()));
       /* Map<String,String> map = (Map<String, String>) JSON.parse(result.getBody());
        log.info("map:{}",map.get("code"));*/
    }

    @Test
    public void authPageTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("code","12121212");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl+"/o2o-support-idaas-application/v1/open/data/rule/role/auth/page";
        Result result = remoteCallUtils.post(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void getRoleAuthUserTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("userCode","81050124");
        map.put("productCode","sjcas");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl +"/o2o-support-idaas-application/v1/open/role/getRoleAuthUser";
        Result result = remoteCallUtils.post(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void getRoleAuthUserTestInfo() {
        String url = ConstantPassword.baseUrl +"/o2o-support-idaas-application/v1/open/role/getRoleAuthUser";

        IdaasRoleUsersDTO info = new IdaasRoleUsersDTO();
        info.setPageNum(1);
        info.setPageSize(10);
        info.setRoleCode("sjcas000000as");
        info.setOrganizationCode("sjcas000001");

        HttpHeaders header = SignatureUtils.generateHeaders(HttpMethod.POST, info, "HTTP/1.1",
                url, ConstantPassword.sjcas_clientid, ConstantPassword.sjcas_client_secret);

        HttpEntity<Map<String, IdaasRoleUsersDTO>> httpEntity = new HttpEntity(info, header);
        ResponseEntity<String> resKongDTO = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println(resKongDTO.getBody());
    }

    @Test
    public void authCodeTest(){
        Map<String, Object> map = new HashMap<>();
        map.put("username","81084193");
        map.put("password","1234qwer");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl+ "/o2o-support-idaas-cas-adapter/v1/upm/up/auth/code";

        Result result = remoteCallUtils.post(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void post0(){
        Map<String, Object> map = new HashMap<>();
        map.put("code","VEdULTM1OS13eEJTLW5vTFBZbWlndGtpeUdsSXIwdlE0MlNGRVd6dmd0bE1SaEg1VDdOSXpTcTd6R3hpUC01S1Z2N3gxdFc2Z3ZvbzJvLXN1cHBvcnQtaWRhYXMtY2FzLThiODhiLTY3ZDU4YzZjYi16Y253Mg==");
        map.put("service","http://sit.usercenter.sitapis.yonghui.cn");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl+ "/o2o-support-idaas-cas-adapter/v1/upm/up/auth/accessToken";

        Result result = remoteCallUtils.post(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void upmUpAuthTest(){
        Map<String, Object> map = new HashMap<>();
        map.put("username","81084193");
        map.put("password","1234qwer");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl+ "/o2o-support-idaas-cas-adapter/v1/upm/up/auth";

        Result result = remoteCallUtils.post(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void QueryResourceTreeTest(){
        Map<String, Object> map = new HashMap<>();
        map.put("productCode",ConstantPassword.sjcas_clientid);
        map.put("parentCode","0");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl + "/o2o-support-idaas-application/v1/open/resource/queryResourceTree";

        Result result = remoteCallUtils.post(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void resourceRevokeAuthRoleTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("productCode","sjztkf");
        map.put("tenantCode","sjztkf");
        map.put("roleCode","sjztkf00000000");
        map.put("resourceCode","donghao");
        map.put("optCode","yunlan");
        map.put("optBy","yunlan");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl + "/o2o-support-idaas-application/v1/open/resource/resourceRevokeAuthRole";

        Result result = remoteCallUtils.post(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void roleAuthorizationUserTest(){
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

        String url = ConstantPassword.baseUrl +"/o2o-support-idaas-application/v1/open/role/RoleAuthorizationUser";

        Result result = remoteCallUtils.post(list,ConstantPassword.sjcas_clientid,ConstantPassword.sjcas_client_secret,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void resourceAddTest(){
        Map<String, Object> map = new HashMap<>();
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
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl +"/o2o-support-idaas-application/v1/open/resource/add";

        Result result = remoteCallUtils.post(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void findOrganizationRolePageTest(){
        Map<String, Object> map = new HashMap<>();
        map.put("organizationCode","sjzt000007");
        map.put("productCode","sjzt");
        map.put("optCode","1001");
        map.put("optBy","澜哥哥");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl +"/o2o-support-idaas-application/v1/open/role/findOrganizationRolePage";

        Result result = remoteCallUtils.post(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void fyFormatDateTest(){
        String time = MapUtils.fyFormatDate();
        log.info("生成的时间：{}",time);
    }

    @Test
    public void mapToStringUrlTest(){
        Map<String,String> map = new HashMap<>();
        map.put("userCode","123456");
        map.put("realName","789");

        String stringByMap = MapUtils.getStringByMap(map);
        log.info("得到的结果:{}",stringByMap);
    }

}
