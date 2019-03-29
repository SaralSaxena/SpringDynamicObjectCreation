package com.saral.springbean.dynamic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DynamicObjectAspect {

	// This comes from the property file
	//dynamic.object.name=customerOne
	@Value("${dynamic.object.name}")
	private String object;

	@Autowired
	private ApplicationContext applicationContext;

	@Pointcut("execution(@com.saral.springbean.dynamic.InjectDynamicObject * *(..))")
	public void beanAnnotatedWithInjectDynamicObject() {
	}

	//custom annotation 
	@Around("beanAnnotatedWithInjectDynamicObject()")
	public Object adviceBeanAnnotatedWithInjectDynamicObject(ProceedingJoinPoint pjp) throws Throwable {
		pjp.proceed();

		// Create the bean or object depends on the property file
		Object createdObject = applicationContext.getBean(object);
		return createdObject;
	}

}
