package com.example.demo.spring.ioc.testioc;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author robert
 * @date 2021/2/28
 */
public class TuLingCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if (context.getBeanFactory().containsBean("tuLingAspect")) {
            return true;
        }
        return false;
    }
}
