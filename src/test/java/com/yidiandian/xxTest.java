package com.yidiandian;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class xxTest extends SpringResttemplateApplicationTests{

    @Autowired
    RestTemplate restTemplate;

    String sitBaseUrl = "http://o2o-support-sit.o2o-support-idaas-gateway.sitgw.yonghui.cn/o2o-support-idaas-application/v1/open";
    String devBaseUrl = "http://o2o-support-dev.o2o-support-idaas-gateway.devgw.yonghui.cn";

    String prodUrl = "http://shenshu-api.yonghui.cn/o2o-support-idaas-application/v1/open";

    @Test
    public void gettestxxx0(){
     /*   Map<String,String> map = new HashMap<>();
        *//*map.put("page", "0");
        map.put("size", "1000");*//*
        map.put("resourceCode", "80728143");
        String remoteUrl = "/resource/list";
        Result result = this.get(map, remoteUrl);
        log.info("result:{}",result);*/
    }


    @Test
    public void gettestxxx(){
     /*   Map<String,String> map = new HashMap<>();
        map.put("page", "0");
        map.put("size", "1000");
        map.put("userCode", "80728143");
        String remoteUrl = "/resource/queryResourceAuthUser";
        Result result = this.get(map, remoteUrl);
        log.info("result:{}",result);*/
    }

    @Test
    public void testx(){
/*        Map<String,String> map = new HashMap<>();
        map.put("telephone", "15951713962");
       // map.put("clientId","qdzs");
       // map.put("clientSecret","T9842R5eeqFubIt2");
        String remoteurl = "/o2o-support-idaas-user/manager/v1/user/queryUserCodeByTelephone";
        Result result = this.get(map, remoteurl);
        log.info("result:{}",result);*/


        // http://o2o-support-dev.o2o-support-idaas-gateway.devgw.yonghui.cn/o2o-support-idaas-user/manager/v1/user/queryUserCodeByTelephone?clientId=qdzs&telephone=15951713962&clientSecret=T9842R5eeqFubIt2
    }

/*    public Result get (Map<String,String> map, String remoteUrl){
        String url = prodUrl +remoteUrl +"?"+ MapUtils.getStringByMap(map);
        log.info("远程调用URL:{}",url);
        HttpHeaders header = SignatureUtils.generateHeaders(HttpMethod.GET, null, "HTTP/1.1", url, "kfpt", "X2sBxDdK3MS2Ft77");
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(header);
        ResponseEntity result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        if (result == null){

        }
        log.info("远程调用返回：{}",result.getBody());
        Map<String,String> resultMap = (Map<String, String>) JSONUtil.parse(result.getBody());

        return  Result.success(resultMap.get("data"));
    }*/

/*
    @Test
    public void posttest(){
        Map<String, String> map = new HashMap<>();
        map.put("productCode","jcsj2020112722");
        map.put("parentCode","80838245");
        map.put("resourceCode","10023");
        map.put("resourceName","yunlan哥哥2222");
        map.put("type","1");
        map.put("orderNum","10");
        map.put("description","我是凤凰小哥哥");
        map.put("path","1001/1002/1003/1004/10");
        map.put("optCode","1001");
        map.put("optBy","澜哥哥");
        map.put("clientId","sjztkf");
        map.put("clientSecret","qmzRUAjEblQis4Vk");
        String remoteUrl = "/resource/add";

        Result result = this.post(map, remoteUrl);
        log.info("得到的结果：{}",result);
    }

    public Result post(Map<String,String> map, String remoteUrl){
        String url = devBaseUrl.concat(remoteUrl);
        HttpHeaders header = SignatureUtils.generateHeaders(HttpMethod.POST, map, "HTTP/1.1", url, "sjztkf", "qmzRUAjEblQis4Vk");
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity(map, header);
        //post请求
        String result = restTemplate.postForObject(url, httpEntity, String.class);
        if (result == null){

        }
        Map<String,String> resultMap = (Map<String, String>) JSONUtil.parse(result);
        return  Result.success(resultMap.get("data"));
    }*/
}
