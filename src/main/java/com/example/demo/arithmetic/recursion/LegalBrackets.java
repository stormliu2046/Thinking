package com.example.demo.arithmetic.recursion;

import java.util.List;

/**
 * @author robert
 */
public class LegalBrackets {

    public List<String> generateParenthesis(int n) {
        _generate(0, 0,  n, "");
        return null;
    }

    private void _generate(int left, int right, int max, String s) {
        // terminator
        if (left == max && left == right) {
            System.out.println(s);
            return;
        }
        // process
        String s1 = s + "(";
        String s2 = s + ")";
        if (left < max) {
            _generate(left + 1, right, max, s1);
        }
        if (left > right) {
            _generate(left, right + 1, max, s2);
        }

        // drill down
        // reverse states
    }

    public static void main(String[] args) {
        new LegalBrackets().generateParenthesis(3);
    }

}
