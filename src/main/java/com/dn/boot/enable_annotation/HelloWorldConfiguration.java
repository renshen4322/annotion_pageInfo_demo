package com.dn.boot.enable_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:HelloWorldConfiguration
 * Package:com.dn.boot.enable
 * Description:
 *
 * @Date:2021/10/23 10:21
 * @Author: mark
 */
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String helloWorld(){
        return "Hello,World";
    }
}
