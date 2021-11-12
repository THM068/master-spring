package com.master.masterspringboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("execution(* com.master.masterspringboot.aop.SampleAdder.*(..)))")
    public void before() {
        logger.info("Entering method");
    }

    @After("execution(* com.master.masterspringboot.aop.SampleAdder.*(..))")
    public void after() {
        logger.info("Exiting method");
    }

    @Around("execution(* com.master.masterspringboot.aop.SampleAdder.*Passenger(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        logger.info("The method name " + methodName);

        Object proceed = proceedingJoinPoint.proceed();

        logger.info("The result is " + proceed);

    }
}
