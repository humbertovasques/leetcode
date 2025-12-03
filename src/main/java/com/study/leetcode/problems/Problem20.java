package com.study.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem20 {

    public static boolean solve(String s) {
        char[] c = s.toCharArray();
        List<Character> chars = new ArrayList<>();

        for (char value : c) {
            if (value == '(' || value == '[' || value == '{') {
                chars.add(value);
            } else if (chars.isEmpty()) {
                return false;
            } else if (value == ')' && chars.get(chars.size() - 1) == '(') {
                chars.remove(chars.size() - 1);
            } else if (value == ']' && chars.get(chars.size() - 1) == '[') {
                chars.remove(chars.size() - 1);
            } else if (value == '}' && chars.get(chars.size() - 1) == '{') {
                chars.remove(chars.size() - 1);
            } else {
                return false;
            }
        }

        return chars.isEmpty();
    }
}
