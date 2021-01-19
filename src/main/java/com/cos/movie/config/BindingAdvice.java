package com.cos.movie.config;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.cos.movie.domain.CommonDto;

@Component
@Aspect
public class BindingAdvice {
	
	private static final Logger log = LoggerFactory.getLogger(BindingAdvice.class);

	@Around("execution(* com.cos.movie.web..*Controller.*(..))")
	public Object validCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object[] args=proceedingJoinPoint.getArgs();
		
		for(Object arg:args) {
			if(arg instanceof BindingResult) {
				BindingResult bindingResult=(BindingResult) arg;
				
				
				if(bindingResult.hasErrors()) {
					return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),"fail");
				}
			}
		}
		return proceedingJoinPoint.proceed();
	}
}

