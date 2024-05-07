package com.project.librarySystem.ASOP;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Aspect
@Component
@Slf4j
public class LoggingAspectOfBook {

    @Pointcut("execution(* com.project.librarySystem.book.controller..*(..))")
    public void loggingPointCutBook(){}


    @Before("loggingPointCutBook()")
    public void beforeLoginMethods(JoinPoint joinPoint) {
        //Logger logger;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = now.format(formatter);
        log.info("Before executing book-api..."+joinPoint.getSignature().getName()+"\n"+formattedDateTime );

    }

    @After("loggingPointCutBook()")
    public void afterLoginMethods(JoinPoint joinPoint)
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = now.format(formatter);
        log.info("After executing book-api..."+joinPoint.getSignature().getName()+"\n"+formattedDateTime );
    }

}
