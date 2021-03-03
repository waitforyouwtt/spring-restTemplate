package com.yidiandian.service.impl;


import com.yidiandian.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetryServiceImpl implements RetryService {

    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 2))
    @Override
    public void devide(double a, double b) {
        log.info("开始进行除法运算");
        if (b == 0) {
            throw new RuntimeException();
        }
        log.info("{} / {} = {}", a, b, a / b);
    }

    @Recover
    public void recover() {
        log.error("被除数不能为0");
    }
}
