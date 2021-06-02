package com.yidiandian;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cas.starter.configuration.SignatureUtils;
import com.yidiandian.constant.ConstantPassword;
import com.yidiandian.service.SingleQueryService;
import com.yidiandian.utils.MapUtils;
import com.yidiandian.utils.Result;
import com.yidiandian.utils.esay.RemoteCallUtils;
import com.yidiandian.view.BaseProductView;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
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

    @Autowired
    RemoteCallUtils getUtils;

    @Autowired
    SingleQueryService singleQueryService;

    @Autowired
    RemoteCallUtils remoteCallUtils;

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

    @Test
    public void findProductTest(){
        List<BaseProductView> allProduct = singleQueryService.findAllProduct();
        log.info("返回的结果:{}", JSONUtil.toJsonStr(allProduct));
    }

    @Test
    public void listAllByParentTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("productCode","bgzt");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl +"/o2o-support-idaas-user/v1/open/organization/listAllByParent?parentCode=0";
        Result result = remoteCallUtils.get(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void getAuthUserTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("productCode","jcsj20201127");
        map.put("userCode","80838245");
        map.put("pageNum","1");
        map.put("pageSize","10");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl +"/o2o-support-idaas-application/v1/open/product/getAuthUser?"+ MapUtils.getObjectByMap(map);
        Result result = remoteCallUtils.get(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void getRoleResourcePageTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("productCode","sjcas");
        map.put("roleCode","sjcas00000008");
        //不支持中文
        //*map.put("realName","王建伟");
        map.put("pageNum","1");
        map.put("pageSize","10");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl +"/o2o-support-idaas-application/v1/open/role/getRoleResourcePage?"+MapUtils.getObjectByMap(map);

        Result result = remoteCallUtils.get(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void queryResourceAuthUserTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("productCode","sjztkf");
        map.put("userCode","80996801");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl +"/o2o-support-idaas-application/v1/open/resource/queryResourceAuthUser?"+MapUtils.getObjectByMap(map);

        Result result = remoteCallUtils.get(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void findRoleListTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("productCode",ConstantPassword.sjcas_clientid);
        map.put("roleCode","kfpt-cs00000001");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl +"/o2o-support-idaas-application/v1/open/role/findRoleList?"+MapUtils.getObjectByMap(map);

        Result result = remoteCallUtils.get(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void findTenantByUserCodeTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("productCode",ConstantPassword.sjcas_clientid);
        map.put("userCode","cu00006725");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl+"/o2o-support-idaas-application/v1/open/findTenantByUserCode?"+MapUtils.getObjectByMap(map);

        Result result = remoteCallUtils.get(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void getAuthOrganizationTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("productCode",ConstantPassword.sjcas_clientid);
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl +"/o2o-support-idaas-application/v1/open/product/getAuthOrganization?"+MapUtils.getObjectByMap(map);

        Result result = remoteCallUtils.get(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void findRoleResourceTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl+ "/o2o-support-idaas-application/v1/open/resource/findRoleResource/d801b01debab45208b6d06dd6d6bcc2d";
        Result result = remoteCallUtils.get(map,url);
        log.info("远程调用url:{}",result);
    }

    @Test
    public void queryResourceAuthTest(){
        Map<String,Object> map = new HashMap<>();
        map.put("productCode",ConstantPassword.sjcas_clientid);
        map.put("userCode","80838245");
        map.put("path","01");
        map.put("resourceType","1");
        map.put("clientId", ConstantPassword.sjcas_clientid);
        map.put("clientSecret",ConstantPassword.sjcas_client_secret);

        String url = ConstantPassword.baseUrl+"/o2o-support-idaas-application/v1/open/resource/queryResourceAuth?"+ MapUtils.getObjectByMap(map);

        Result result = remoteCallUtils.get(map,url);
        log.info("远程调用url:{}",result);
    }

}

