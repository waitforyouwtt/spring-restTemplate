package com.yidiandian;

import com.yidiandian.service.RetryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetryTest extends SpringResttemplateApplicationTests{

    @Autowired
    RetryService retryService;

    @Test
    public void retryTest() {
        //int count = retryService.retry(-1);
        retryService.devide(2,0);
        //logger.info("库存为：" + count);
    }
}
