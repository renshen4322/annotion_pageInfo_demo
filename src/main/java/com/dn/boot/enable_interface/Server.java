package com.dn.boot.enable_interface;

/**
 * ClassName:Server
 * Package:com.dn.boot.enable_interface
 * Description:
 *
 * @Date:2021/10/23 10:42
 * @Author: mark
 */
public interface Server {
    void start();
    void stop();
    enum Type{
        Http,
        Ftp
    }
}
