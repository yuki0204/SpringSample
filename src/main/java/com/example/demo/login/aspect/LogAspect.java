package com.example.demo.login.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	@Around("execution(* *..*.*Controller.*(..))")
	public Object startLog(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("メソッド開始：" + jp.getSignature());
		try {
			// proceed で実際に対象のメソッドを実行している
			Object result = jp.proceed();
			System.out.println("メソッド終了" + jp.getSignature());

			return result;
		} catch (Exception e) {
			System.out.println("メソッド異常終了" + jp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}

	// コントローラークラスの全てのメソッドを対象
//	@Before("execution(* *..*.*Controller.*(..))")
//	public void startLog(JoinPoint jp) {
//		System.out.println("メソッド開始：" + jp.getSignature());
//	}
//
//	@After("execution(* *..*.*Controller.*(..))")
//	public void endLog(JoinPoint jp) {
//		System.out.println("メソッド終了" + jp.getSignature());
//	}
}
