package com.dn.boot.enable_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName:EnableHelloWorldBootstrap
 * Package:com.dn.boot.enable1
 * Description:
 *
 * @Date:2021/10/23 10:31
 * @Author: mark
 */
@EnableHelloWorld
//@Configuration
public class EnableHelloWorldBootstrap {
    public static void main(String[] args) {
        //构建Annotation 配置驱动Spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册当前引导类 （被@Configuration标注）到Spring上下文
        context.register(EnableHelloWorldBootstrap.class);
        //启动上下文
        context.refresh();
        String hellWorld = context.getBean("helloWorld",String.class);
        System.out.printf("hellWorld=%s \n",hellWorld);
        //关闭上下文
        context.close();
    }
}
