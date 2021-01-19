package com.example.demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author robert
 */
public class RegexTest {

    public static void main(String[] args) {
        String regEx = "^.*[(<)|(>)|(|)|(\\*)|(?)|(\\\\)|(/)].*$";
        String str = "wo<shishui";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        System.out.println(m.find());
    }

}
