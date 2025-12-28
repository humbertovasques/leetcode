//Given a string s, return the longest palindromic substring in s.
//
//
// Example 1:
//
//
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
//
//
// Example 2:
//
//
//Input: s = "cbbd"
//Output: "bb"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consist of only digits and English letters.
//
package com.study.leetcode.problems;

public class Problem5 {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();
        if (reversed.equals(s)) {
            return reversed;
        }

        StringBuilder result = new StringBuilder(s.charAt(0) + "");

        for (int i = 0; i < s.length(); i++) {
            int beginIndex = i;
            int endIndex = s.indexOf(s.charAt(beginIndex), beginIndex + 1);

            while (endIndex != -1) {
                String sub = s.substring(beginIndex, endIndex + 1);
                if (isPalindrome(sub) && sub.length() > result.length()) {
                    result.replace(0, result.length(), sub);
                }

                endIndex = s.indexOf(s.charAt(endIndex), endIndex + 1);
            }
        }

        return result.toString();
    }

    private boolean isPalindrome(String s) {
        int max = s.length() - 1;
        for (int i = 0; i <= max/2; i++) {
            if (s.charAt(i) != s.charAt(max - i)) {
                return false;
            }
        }

        return true;
    }
}
