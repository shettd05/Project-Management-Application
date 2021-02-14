package com.deepak.pma.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerClass {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Pointcut("within(com.deepak.pma.controller..*)")
	public void logExecutionPlace() {
		
	}
	
	@After("logExecutionPlace()")
	public void loggingFormat() {
		log.debug("********************************");
	}
}
