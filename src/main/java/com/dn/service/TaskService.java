package com.dn.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Future;

@Component
@Slf4j
@Async
public class TaskService {

        //@Async("taskExecutor")
    @Async
    public Future<String> doTaskOne() throws Exception {
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("当前线程为 {}，请求方法为 {}，请求路径为：{}, 请求参数：{}", Thread.currentThread().getName(), request.getMethod(),
                request.getRequestURL().toString(),request.getAttribute("name"));
        return new AsyncResult<String>("任务一完成，耗时" + (end - start) + "毫秒");
    }

        //@Async("taskExecutor")
    @Async
    public Future<String> doTaskTwo() throws Exception {
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("当前线程为 {}，请求方法为 {}，请求路径为：{}, 请求参数：{}", Thread.currentThread().getName(), request.getMethod(),
                request.getRequestURL().toString(),request.getAttribute("age"));
        return new AsyncResult<String>("任务二完成，耗时" + (end - start) + "毫秒");
    }

        //@Async("taskExecutor")
    @Async
    public Future<String> doTaskThree() throws Exception {
        log.info("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end - start) + "毫秒");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("当前线程为 {}，请求方法为 {}，请求路径为：{}, 请求参数：{}", Thread.currentThread().getName(), request.getMethod(),
                request.getRequestURL().toString(),request.getAttribute("six"));
        return new AsyncResult<String>("任务三完成，耗时" + (end - start) + "毫秒");
    }
}

