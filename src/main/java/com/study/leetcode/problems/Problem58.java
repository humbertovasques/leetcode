package com.study.leetcode.problems;

//Given a string s consisting of words and spaces, return the length of the
//last word in the string.
//
// A word is a maximal substring consisting of non-space characters only.
//
//
// Example 1:
//
//
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.
//
//
// Example 2:
//
//
//Input: s = "   fly me   to   the moon  "
//Output: 4
//Explanation: The last word is "moon" with length 4.
//
//
// Example 3:
//
//
//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10⁴
// s consists of only English letters and spaces ' '.
// There will be at least one word in s.

public class Problem58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int beginIndex = 0;
        int endIndex = s.length() - 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                endIndex = i;
                break;
            }
        }

        for (int j = endIndex - 1; j >= 0; j--) {
            if (s.charAt(j) == ' ') {
                beginIndex = j + 1;
                break;
            }
        }

        return endIndex - beginIndex + 1;
    }
}
