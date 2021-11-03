package com.dn.boot.enable_interface;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName:EnableHelloWorldBootstrap
 * Package:com.dn.boot.enable1
 * Description:
 *
 * @Date:2021/10/23 10:31
 * @Author: mark
 */
@EnableServer(type = Server.Type.Ftp)
//@Configuration
public class EnableServerBootstrap {
    public static void main(String[] args) {
        //构建Annotation 配置驱动Spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册当前引导类 （被@Configuration标注）到Spring上下文
        context.register(EnableServerBootstrap.class);
        //启动上下文
        context.refresh();
        //获取Server Bean 对象,实际为HttpServer
        Server server = context.getBean(Server.class);
        server.start();
        server.stop();
    }
}
