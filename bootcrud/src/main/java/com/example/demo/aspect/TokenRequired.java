package com.example.demo.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Retention : ��� Ÿ�ֿ̹� ����� ���ΰ�
@Retention(RetentionPolicy.RUNTIME) //��Ÿ�ӽÿ� ����
@Target(ElementType.METHOD) //�޼��尡 Ÿ��
public @interface TokenRequired {

}
