package com.example.demo.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author robert
 */
@Slf4j
@Component
@Aspect
public class FeignExceptionApiAspect {
    @Around(value = "(@annotation(feignExceptionApi) || @within(feignExceptionApi))")
    Object around4Method(ProceedingJoinPoint joinPoint, FeignExceptionApi feignExceptionApi) {
        log.info("进入切面方法：" + System.currentTimeMillis());
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.info("抛出异常：" + System.currentTimeMillis());
        }
        return proceed;
    }
}
