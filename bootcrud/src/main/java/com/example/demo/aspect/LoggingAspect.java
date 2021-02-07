package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//@Before : 메서드 호출 이전 어드바이스 수행
	//@After : 메서드 호출 이후 어드바이스 수행(결과와 상관없음)
	//@AfterReturning : 메서드가 성공적으로 리턴값 반환했을 경우 어디바이스 수행
	//@Afterthrowing : 메서드 수행중에 예외가 던저지면 어드바이스 수행
	//@Around : 메서드 호출 전 후로 어드바이스 수행
	
	//service 패키지 안에 들어가는 어두가 get인 메서드를 시작 전에 호출
	@Before("execution(* com.example.demo.service.*.get*(..))")
	public void loggerBefore() {
		System.out.println("get으로 시작되는 메서드 시작");
	}

	//service 패키지 안에 들어가는 어두가 get인 메서드가 끝난 후 호출
	@After("execution(* com.example.demo.service.*.get*(..))")
	public void loggerAfter() {
		System.out.println("get으로 시작되는 메서드 끝");
	}
	
	//UserController의 모든 메서드에 대해 호출
	@Around("execution(* com.example.demo.controller.UserController.*(..))")
	public Object loggerAround(ProceedingJoinPoint pjp) throws Throwable {
		long beforeTimeMillis = System.currentTimeMillis();
		System.out.println("[UserController] 실행 시작 : "
				+pjp.getSignature().getDeclaringTypeName() + "."
				+pjp.getSignature().getName());
		Object result = pjp.proceed();
		
		long afterTimeMillis = System.currentTimeMillis() - beforeTimeMillis;
		System.out.println("[UserController] 실행 완료: " + afterTimeMillis + " 밀리초 소요, "
				+pjp.getSignature().getDeclaringTypeName() + "."
				+pjp.getSignature().getName());
		
		return result;
	}
}
