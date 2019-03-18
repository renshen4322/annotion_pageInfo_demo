package com.dn.aspect;


import java.util.Collection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dn.util.BeanUtil;

@Component
@Aspect
public class SetFeildValueAspect {
	
	@Autowired
	private BeanUtil beanUtil;
	
	@Around("@annotation(com.dn.annotation.NeedSetFeildValue)")
	public Object doSetFieldValue(ProceedingJoinPoint pjp) throws Throwable{
		Object ret = pjp.proceed();
		if(ret instanceof Collection){
			this.beanUtil.setFeildValueForCollection((Collection)ret);
		}else{
			this.beanUtil.setFeildValueForCollection2(ret);
			 //如果返回的是一个单个对象，自己补全
		}
		return ret;
	}

}
