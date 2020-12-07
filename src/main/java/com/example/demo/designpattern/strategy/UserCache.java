package com.example.demo.designpattern.strategy;

import java.io.IOException;
import java.util.Properties;

/**
 * @author robert
 */
public class UserCache {

    private Strategy strategy;

    public UserCache(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(UserCache.class.getClassLoader().getResourceAsStream("strategy.properties"));
            String type = properties.getProperty("strategy");
            UserCache userCache = new UserCache(StrategyFactory.getStrategy(type));
            System.out.println(userCache);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
