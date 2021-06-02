package com.yidiandian.utils.esay;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.cas.starter.configuration.SignatureUtils;
import com.yidiandian.constant.ConstantPassword;
import com.yidiandian.constant.ConstantUrl;
import com.yidiandian.utils.Result;
import com.yidiandian.view.ProductAuthMultiUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Service
public class RemoteCallUtils {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取无参数的get请求
     */
    public Result get(String url){
        String response = restTemplate.getForObject(ConstantPassword.baseUrl +url, String.class);
        Map<String,Object> maps = (Map) JSONUtil.parse(response);
        return new Result(ConstantUrl.success,maps.get("message").toString(),maps.get("result"));
    }

    public Result get(Map<String,Object> map,String url){
        String clientId = (String) map.get("clientId");
        String clientSecret = (String) map.get("clientSecret");

        HttpHeaders header = SignatureUtils.generateHeaders(HttpMethod.GET, map, "HTTP/1.1", url, clientId,clientSecret);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(map, header);

        ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Map.class);
        if (Objects.isNull(responseEntity)){
            return new Result(ConstantUrl.error,ConstantUrl.error_msg,null);
        }
        return new Result(ConstantUrl.success,ConstantUrl.success_msg,responseEntity.getBody());
    }

    public Result post(Map<String,Object> map,String url){
        String clientId = (String) map.get("clientId");
        String clientSecret = (String) map.get("clientSecret");
        HttpHeaders header = SignatureUtils.generateHeaders(HttpMethod.POST, map, "HTTP/1.1", url, clientId,clientSecret);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(map, header);
        ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);
        if (Objects.isNull(responseEntity)){
            return new Result(ConstantUrl.error,ConstantUrl.error_msg,null);
        }
        return new Result(ConstantUrl.success,ConstantUrl.success_msg,responseEntity.getBody());
    }

    public Result post(List list,String clientId,String clientSecret, String url){
        HttpHeaders header = SignatureUtils.generateHeaders(HttpMethod.POST, list, "HTTP/1.1", url, clientId,clientSecret);
        HttpEntity<Object> httpEntity = new HttpEntity(list, header);
        ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);
        if (Objects.isNull(responseEntity)){
            return new Result(ConstantUrl.error,ConstantUrl.error_msg,null);
        }
        return new Result(ConstantUrl.success,ConstantUrl.success_msg,responseEntity.getBody());
    }
}
