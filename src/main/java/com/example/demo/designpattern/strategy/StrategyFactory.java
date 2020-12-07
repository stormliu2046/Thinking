package com.example.demo.designpattern.strategy;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robert
 */
public class StrategyFactory {
    private final static Map<String, Strategy> strategies = new HashMap<>();

    static {
        strategies.put("A", new ConcreteStrategyA());
        strategies.put("B", new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String strategyType) {
        if (StringUtils.isEmpty(strategyType)) {
            throw new RuntimeException("strategyType cannot be null");
        }
        return strategies.get(strategyType);
    }
}
