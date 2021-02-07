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
	
	//@Before : �޼��� ȣ�� ���� �����̽� ����
	//@After : �޼��� ȣ�� ���� �����̽� ����(����� �������)
	//@AfterReturning : �޼��尡 ���������� ���ϰ� ��ȯ���� ��� �����̽� ����
	//@Afterthrowing : �޼��� �����߿� ���ܰ� �������� �����̽� ����
	//@Around : �޼��� ȣ�� �� �ķ� �����̽� ����
	
	//service ��Ű�� �ȿ� ���� ��ΰ� get�� �޼��带 ���� ���� ȣ��
	@Before("execution(* com.example.demo.service.*.get*(..))")
	public void loggerBefore() {
		System.out.println("get���� ���۵Ǵ� �޼��� ����");
	}

	//service ��Ű�� �ȿ� ���� ��ΰ� get�� �޼��尡 ���� �� ȣ��
	@After("execution(* com.example.demo.service.*.get*(..))")
	public void loggerAfter() {
		System.out.println("get���� ���۵Ǵ� �޼��� ��");
	}
	
	//UserController�� ��� �޼��忡 ���� ȣ��
	@Around("execution(* com.example.demo.controller.UserController.*(..))")
	public Object loggerAround(ProceedingJoinPoint pjp) throws Throwable {
		long beforeTimeMillis = System.currentTimeMillis();
		System.out.println("[UserController] ���� ���� : "
				+pjp.getSignature().getDeclaringTypeName() + "."
				+pjp.getSignature().getName());
		Object result = pjp.proceed();
		
		long afterTimeMillis = System.currentTimeMillis() - beforeTimeMillis;
		System.out.println("[UserController] ���� �Ϸ�: " + afterTimeMillis + " �и��� �ҿ�, "
				+pjp.getSignature().getDeclaringTypeName() + "."
				+pjp.getSignature().getName());
		
		return result;
	}
}
