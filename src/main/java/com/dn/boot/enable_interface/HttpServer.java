package com.dn.boot.enable_interface;

import org.springframework.stereotype.Component;

/**
 * ClassName:HttpServer
 * Package:com.dn.boot.enable_interface
 * Description:
 *
 * @Date:2021/10/23 10:43
 * @Author: mark
 */
@Component
public class HttpServer implements Server{
    @Override
    public void start() {
        System.out.println("Http服务器启动中……");
    }

    @Override
    public void stop() {
        System.out.println("Http服务器关闭中……");
    }
}
