package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author robert
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface FeignExceptionApi {
}
