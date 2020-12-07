package com.example.demo.designpattern.factory.factory;

import com.example.demo.designpattern.factory.IRuleConfigParser;

/**
 * 新增一个实现了 IRuleConfigParserFactory 接口的 Factory 类即可
 * @author robert
 */
public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
