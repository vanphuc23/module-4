package com.example.spring_data_jpa.aop;

import com.example.spring_data_jpa.dto.StudentDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    static int count = 0;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @AfterThrowing("execution(* com.example.spring_data_jpa.controller.StudentController.save(..))")
    public void AdviceBefore(JoinPoint joinPoint) {
//        String nameMethod = joinPoint.getSignature().getName();
//        logger.info("Tên phương thức: " + nameMethod);
        Object[] objects = joinPoint.getArgs();
        StudentDto studentDto = (StudentDto) objects[0];
        System.out.println("-----------------");
        System.out.println("Name: "+studentDto.getName());
        System.out.println("-----------------");
    }
    @Around("execution(* com.example.spring_data_jpa.controller.StudentController.showList(..))")
    public Object AroundDemo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("---------------");
        System.out.println("Trước");
        System.out.println("---------------");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("---------------");
        System.out.println("Sau");
        System.out.println("---------------");
        return object;
    }
}
