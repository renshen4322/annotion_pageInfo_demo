package com.dn.controller;

import com.dn.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Future;

@RestController
@Slf4j
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public String taskExecute() {
        try {
            Future<String> r1 = taskService.doTaskOne();
            Future<String> r2 = taskService.doTaskTwo();
            Future<String> r3 = taskService.doTaskThree();
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            request.setAttribute("name", "李小龙");
            request.setAttribute("age",23);
            request.setAttribute("six","男");
            log.info("当前线程为 {}，请求方法为 {}，请求路径为：{}", Thread.currentThread().getName(), request.getMethod(), request.getRequestURL().toString());
            while (true) {
                if (r1.isDone() || r2.isDone() || r3.isDone()) {
                    log.info("execute all tasks");
                    break;
                }
                Thread.sleep(200);
            }
            log.info("\n" + r1.get() + "\n" + r2.get() + "\n" + r3.get());
        } catch (Exception e) {
            log.error("error executing task for {}", e.getMessage());
        }

        return "ok";
    }

}

