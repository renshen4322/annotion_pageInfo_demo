package com.dn.boot.enable_interface;

import com.dn.boot.enable_annotation.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * ClassName:EnableServer
 * Package:com.dn.boot.enable_interface
 * Description:
 *
 * @Date:2021/10/23 10:47
 * @Author: mark
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(ServerImportBeanDefinitionRegistrar.class)  //替换ServerImportSelector  新方式
public @interface EnableServer {
    Server.Type type();
}
