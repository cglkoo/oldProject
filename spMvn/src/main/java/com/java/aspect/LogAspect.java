package com.java.aspect;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class LogAspect {  //日志管理，面向切面编程
	private Logger logger=LogManager.getRootLogger();

	public LogAspect() {
		
	}
	public void doBefore(JoinPoint joinPoint){   //传入连接点
		
		logger.debug("=====执行方法前做的日志记录=====");
		String methodName=joinPoint.getSignature().getName();  //获得方法名
		logger.info("执行的方法是："+methodName);
		List<Object> param= Arrays.asList(joinPoint.getArgs()); //获得方法得参数
		logger.info("方法的参数："+param);
		
	}
	public void doAfter(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();  //获得方法名
		logger.info("执行的方法是："+methodName);
		logger.debug("=====执行方法后做的日志记录=====");
	}
}
