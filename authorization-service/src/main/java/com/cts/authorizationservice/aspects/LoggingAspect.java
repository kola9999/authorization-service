package com.cts.authorizationservice.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	@Before(value = "execution(* com.cts..*(..))")
	public void beforeLog(JoinPoint joinPoint) {
		log.debug("END: {}", joinPoint.getSignature().getName());
	}

	@Before(value = "execution(* com.cts..*(..))")
	public void afterLog(JoinPoint joinPoint) {
		log.debug("BEGIN: {}", joinPoint.getSignature().getName());
	}
}