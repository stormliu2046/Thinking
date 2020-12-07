package com.example.demo.designpattern.factory.simplefactory;

import com.example.demo.designpattern.factory.IRuleConfigParser;
import com.example.demo.designpattern.factory.parser.JsonRuleConfigParser;
import com.example.demo.designpattern.factory.parser.PropertiesRuleConfigParser;
import com.example.demo.designpattern.factory.parser.XmlRuleConfigParser;
import com.example.demo.designpattern.factory.parser.YamlRulConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * 稍微不符合开闭原则没什么问题，多态或设计模式替代if分支判断，虽然提高代码的扩展性，更加符合开闭原则，
 * 但是增加了类的个数，牺牲了代码的可读性
 * @author robert
 */
public class RuleConfigParserFactory {

    //简单工厂第一种实现
    public static IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRulConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }

    //简单工厂模式第二种实现
    public static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRulConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParse(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
        return parser;
    }
}
