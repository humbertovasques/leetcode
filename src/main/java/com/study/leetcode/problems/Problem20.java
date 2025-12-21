package com.study.leetcode.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem20 {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char pop = stack.pop();

            if (c == ')' && pop != '(') {
                return false;
            } else if (c == ']' && pop != '[') {
                return false;
            } else if (c == '}' && pop != '{') {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValidV1(String s) {
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
