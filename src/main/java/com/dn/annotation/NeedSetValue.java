package com.dn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedSetValue {
	
	/**
	 * 接下来就定义它的属性
	 * */
	
	/**他的调用的bean
	 * 
	 */
	Class<?> beanClass();
	
   /**
    * 它要传入的参数
    */
	String param() default "";
	
	
   /**
    * 调用的哪个方法
    * */
	String method();
	
	/**
	 * 他要获取结果集中的哪个值？
	 * */
	String targetField();
}
