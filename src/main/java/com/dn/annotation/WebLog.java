package com.dn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:WebLog
 * Package:com.dn.annotation
 * Description:
 *
 * @Date:2021/10/23 12:51
 * @Author: mark
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.PARAMETER, ElementType.METHOD })
public @interface WebLog {

    /**
     * 渠道
     * @return 渠道标识
     */
    String channel() default "web";

    /**
     * 功能名称
     * @return 功能名称
     */
    String name() default "";

    /**
     * 方法名称
     * @return 方法名称
     */
    String action() default "";

    /**
     * 是否保存（默认不保存）
     * @return 是否保存
     */
    boolean saveFlag() default false;

}