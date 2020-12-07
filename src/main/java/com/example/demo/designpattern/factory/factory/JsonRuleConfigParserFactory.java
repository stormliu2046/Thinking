package com.example.demo.designpattern.factory.factory;

import com.example.demo.designpattern.factory.IRuleConfigParser;
import com.example.demo.designpattern.factory.parser.JsonRuleConfigParser;

/**
 * @author robert
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
