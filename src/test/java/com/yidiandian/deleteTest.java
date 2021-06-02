package com.yidiandian;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author 凤凰小哥哥
 * @date 2020-12-20
 */
@Component
@Slf4j
public class deleteTest extends SpringResttemplateApplicationTests {

    private String baseUrl = "http://localhost:8002/brand";
    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testDelete(){
        String url = baseUrl+"/{id}";
        restTemplate.delete(url,325414);
    }

}
