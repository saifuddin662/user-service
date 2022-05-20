package com.saif.userservice.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Pointcut("within(com.saif.userservice.controller..*)" +
            "|| within(com.saif.userservice.service..*)" +
            "|| within(com.saif.userservice.repository..*)" +
            "|| within(com.saif.userservice.feign..*)")
    public void allPackagePointcut() {}

    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
            " || within(@org.springframework.stereotype.Service *)" +
            " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {
    }

    @AfterReturning(pointcut = "allPackagePointcut() && springBeanPointcut()", returning = "retVal")
    public Object logAfterReturning(JoinPoint pjp, Object retVal) {
        log.info("{} return from {}", retVal.toString(), pjp.getSignature().getName());
        return pjp.getSignature().toString();
    }

    @AfterThrowing(pointcut = "allPackagePointcut() && springBeanPointcut()", throwing = "ex")
    public void logAfterExceptionThrowing(JoinPoint joinPoint, Exception ex) {
        log.error("{} error thrown from {}", ex.getMessage(), joinPoint.getSignature().getName());
    }
}
