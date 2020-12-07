package com.example.demo.designpattern.factory.simplefactory;

import com.example.demo.designpattern.factory.IRuleConfigParser;
import com.example.demo.designpattern.factory.InvalidRuleConfigException;
import com.example.demo.designpattern.factory.RuleConfig;

/**
 * 为了让类的职责更加单一、代码更加清晰，将createParser()函数剥离到一个独立的类中，
 * 让这个类只负责对象的创建
 * @author robert
 */
public class RuleConfigSource2 {
    public RuleConfig load(String ruleConfigFilePath) throws InvalidRuleConfigException {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
        if (parser == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        String configText = ""; //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
