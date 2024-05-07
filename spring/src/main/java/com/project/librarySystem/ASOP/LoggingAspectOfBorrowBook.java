package com.project.librarySystem.ASOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectOfBorrowBook {

    @Pointcut("execution(*  com.project.librarySystem.borrowBook.controller..*(..))")
    public void loggingPointCutBorrowBook(){}


    @Before("loggingPointCutBorrowBook()")
    public void beforeLoginMethods(JoinPoint joinPoint) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = now.format(formatter);
        //Logger logger;
        log.info("Before executing book-api..."+joinPoint.getSignature().getName()+"\n"+formattedDateTime );
    }

    @After("loggingPointCutBorrowBook()")
    public void afterLoginMethods(JoinPoint joinPoint)
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = now.format(formatter);
        log.info("After executing book-api..."+joinPoint.getSignature().getName()+"\n"+formattedDateTime );
    }

}
