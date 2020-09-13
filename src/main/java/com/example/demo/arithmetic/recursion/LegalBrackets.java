package com.example.demo.arithmetic.recursion;

import java.util.List;

/**
 * @author robert
 */
public class LegalBrackets {

    public List<String> generateParenthesis(int n) {
        _generate( 0, 2 * n, "");
        return null;
    }

    private void _generate(int level, int max, String s) {
        // terminator
        if (level >= max) {
            System.out.println(s);
            return;
        }
        // process
        String s1 = s + "(";
        String s2 = s + ")";
        _generate(level + 1, max, s1);
        _generate(level + 1, max, s2);
        // drill down
        // reverse states
    }

    public static void main(String[] args) {
        new LegalBrackets().generateParenthesis(3);
    }

}
