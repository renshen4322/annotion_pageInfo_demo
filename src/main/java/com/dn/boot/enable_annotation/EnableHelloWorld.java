package com.dn.boot.enable_annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * ClassName:EnableWebMvc
 * Package:com.dn.boot.enable
 * Description:
 *
 * @Date:2021/10/23 10:19
 * @Author: mark
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {
}
