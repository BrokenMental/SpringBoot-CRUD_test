package com.example.demo.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Retention : 어느 타이밍에 실행될 것인가
@Retention(RetentionPolicy.RUNTIME) //런타임시에 실행
@Target(ElementType.METHOD) //메서드가 타깃
public @interface TokenRequired {

}
