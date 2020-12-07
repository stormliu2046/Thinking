package com.example.demo.designpattern.factory.dependencyinjection;

import java.io.InputStream;
import java.util.List;

/**
 * @author robert
 */
public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);

    List<BeanDefinition> parse(String configContent);
}
