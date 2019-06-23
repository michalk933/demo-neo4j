package com.example.demoneo4j.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Slf4j
@Aspect
@Component
public class LogAop {

    @Around("@annotation(LogExecutionAop)")
    public Object aroundLogExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(String.format("Start method %1$s with parameters: %2$s", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
        final Object result = joinPoint.proceed();
        log.info(String.format("Result from method %1$s is %2$s", joinPoint.getSignature().getName(), result));
        return result;
    }

}
