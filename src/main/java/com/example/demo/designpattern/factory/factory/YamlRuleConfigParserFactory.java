package com.example.demo.designpattern.factory.factory;

import com.example.demo.designpattern.factory.IRuleConfigParser;
import com.example.demo.designpattern.factory.parser.YamlRulConfigParser;

/**
 * @author robert
 */
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRulConfigParser();
    }
}
