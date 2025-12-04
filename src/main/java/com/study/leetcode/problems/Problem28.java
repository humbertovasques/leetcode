package com.study.leetcode.problems;

public class Problem28 {
    public int strStr(String haystack, String needle) {

        if (haystack.equals(needle))
            return 0;

        boolean match;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                match = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i+j) != needle.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match)
                    return i;
            }
        }

        return -1;
    }
}
