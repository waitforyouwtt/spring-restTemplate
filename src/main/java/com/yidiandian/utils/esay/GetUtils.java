package com.yidiandian.utils.esay;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.yidiandian.constant.ConstantUrl;
import com.yidiandian.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
public class GetUtils {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取无参数的get请求
     */

    public Result get(String url){
        String response = restTemplate.getForObject(ConstantUrl.baseUrl+url, String.class);
        log.info("获取到的结果是:{}", JSONUtil.toJsonStr(response));
        Map<String,Object> maps = (Map) JSONUtil.parse(response);
        return new Result(200000,maps.get("message").toString(),maps.get("result"));
    }
}
