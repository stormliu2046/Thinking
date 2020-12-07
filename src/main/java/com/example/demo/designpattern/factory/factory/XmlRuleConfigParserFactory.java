package com.example.demo.designpattern.factory.factory;

import com.example.demo.designpattern.factory.IRuleConfigParser;
import com.example.demo.designpattern.factory.parser.XmlRuleConfigParser;

/**
 * @author robert
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
