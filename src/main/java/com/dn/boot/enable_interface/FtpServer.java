package com.dn.boot.enable_interface;

/**
 * ClassName:FtpServer
 * Package:com.dn.boot.enable_interface
 * Description:
 *
 * @Date:2021/10/23 10:45
 * @Author: mark
 */
public class FtpServer implements Server{
    @Override
    public void start() {
        System.out.println("Ftp服务器启动中……");
    }

    @Override
    public void stop() {
        System.out.println("Ftp服务器关闭中……");
    }
}
