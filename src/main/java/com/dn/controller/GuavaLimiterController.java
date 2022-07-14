package com.dn.controller;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @Date:2022/7/14 19:41
 * @Author: mark
 */
@RestController
@Slf4j
public class GuavaLimiterController {
    //每秒钟可以创建两个令牌
    RateLimiter limiter = RateLimiter.create(2.0);

    //非阻塞限流
    @GetMapping("/tryAcquire")
    public String tryAcquire(Integer count){
        //count 每次消耗的令牌
        if(limiter.tryAcquire(count)){
            log.info("成功，允许通过，速率为{}",limiter.getRate());
            return "success";
        }else{
            log.info("错误，不允许通过，速率为{}",limiter.getRate());
            return "fail";
        }
    }

    //限定时间的非阻塞限流
    @GetMapping("/tryAcquireWithTimeout")
    public String tryAcquireWithTimeout(Integer count, Integer timeout){
        //count 每次消耗的令牌  timeout 超时等待的时间
        if(limiter.tryAcquire(count,timeout, TimeUnit.SECONDS)){
            log.info("成功，允许通过，速率为{}",limiter.getRate());
            return "success";
        }else{
            log.info("错误，不允许通过，速率为{}",limiter.getRate());
            return "fail";
        }
    }

    //同步阻塞限流
    @GetMapping("/acquire")
    public String acquire(Integer count){
        limiter.acquire(count);
        log.info("成功，允许通过，速率为{}",limiter.getRate());
        return "success";
    }
}
