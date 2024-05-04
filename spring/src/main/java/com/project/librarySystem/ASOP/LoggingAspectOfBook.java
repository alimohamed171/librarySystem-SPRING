package com.project.librarySystem.ASOP;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;



@Aspect
@Component
@Slf4j
public class LoggingAspectOfBook {

    @Pointcut("execution(* com.project.librarySystem.book.controller..*(..))")
    public void loggingPointCutBook(){}


    @Before("loggingPointCutBook()")
    public void beforeLoginMethods(JoinPoint joinPoint) {
        //Logger logger;
        log.info("Before executing book-api..."+joinPoint.getSignature().getName() );
    }

    @After("loggingPointCutBook()")
    public void afterLoginMethods(JoinPoint joinPoint)
    {
        log.info("After executing book-api..."+joinPoint.getSignature().getName() );
    }

}