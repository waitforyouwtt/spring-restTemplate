package com.yidiandian;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 凤凰小哥哥
 * @date 2020-12-20
 */
@Component
@Slf4j
public class mapTest extends SpringResttemplateApplicationTests{

    @Test
    public void mapToStringUrlTest(){
        Map<String,String> map = new HashMap<>();
        map.put("userCode","123456");
        map.put("realName","789");

        String stringByMap = MapUtils.getStringByMap(map);
        log.info("得到的结果:{}",stringByMap);
    }
}
