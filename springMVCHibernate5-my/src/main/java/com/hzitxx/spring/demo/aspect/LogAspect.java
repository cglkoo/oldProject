package com.hzitxx.spring.demo.aspect;

import java.util.Arrays;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class LogAspect {
	
	
	private Logger logger = LogManager.getRootLogger();
	
	/**
	 * 调用业务逻辑方法前的 Advice
	 * 方法关联一个链接点参数joinPoint
	 * @param joinPoint
	 */
	public void doBefore(JoinPoint joinPoint){
		//System.out.println("===== 执行方法前的动作 =====");
		logger.info("==== 执行任务前做日志记录 ====");
		String methodName = joinPoint.getSignature().getName();
		//System.out.println("执行的方法是:" + methodName);
		logger.info("执行的方法是:" + methodName);
		List<Object> param = Arrays.asList(joinPoint.getArgs());
		//System.out.println("方法的参数有：" + param);
		logger.debug("该方法的参数是:" + param);
	}
	
	/**
	 * 调用业务逻辑方法后的Advice
	 * 方法关联一个链接点参数joinPoint
	 * @param joinPoint
	 */
	public void doAfter(JoinPoint joinPoint){
		//System.out.println("===== 执行方法后的动作 =====");
		logger.info("===== 执行方法后的动作 =====");
		String methodName = joinPoint.getSignature().getName();
		//System.out.println("执行的方法是:" + methodName);
		logger.info("执行的方法是:" + methodName);
	}
	
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		logger.error("==== 方法抛异常后 ===");
		logger.error("执行的方法是:" + joinPoint.getSignature().getName() + ",异常信息是:");
		logger.error(ex.getMessage());
	}

}
