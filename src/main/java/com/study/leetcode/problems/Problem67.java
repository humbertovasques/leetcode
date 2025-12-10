package com.study.leetcode.problems;

// [67]Add Binary
// Given two binary strings a and b, return their sum as a binary string.
//
//
// Example 1:
// Input: a = "11", b = "1"
// Output: "100"
//
// Example 2:
// Input: a = "1010", b = "1011"
// Output: "10101"
//
//
// Constraints:
//
// 1 <= a.length, b.length <= 10⁴
// a and b consist only of '0' or '1' characters.
// Each string does not contain leading zeros except for the zero itself.
//
// Related Topics:
//      Math
//      String
//      Bit Manipulation
//      Simulation

public class Problem67 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        String s1;
        String s2;
        if (a.length() > b.length()) {
            s2 = new StringBuilder(a).reverse().toString();
            s1 = new StringBuilder(b).reverse().toString();
        } else {
            s2 = new StringBuilder(b).reverse().toString();
            s1 = new StringBuilder(a).reverse().toString();
        }
        int min = Math.min(a.length(), b.length());
        int max = Math.max(a.length(), b.length());

        int carry = 0;
        for (int i = 0; i < max + carry; i++) {
            if (i < min) {
                int x = Integer.parseInt(String.valueOf(s2.charAt(i)));
                int y = Integer.parseInt(String.valueOf(s1.charAt(i)));
                int sum = x + y + carry;
                carry = sum / 2;
                result.append(sum % 2);
            } else if (i < max) {
                int x = Integer.parseInt(String.valueOf(s2.charAt(i)));
                int sum = x + carry;
                carry = sum / 2;
                result.append(sum % 2);
            } else {
                int sum = carry;
                carry = sum / 2;
                result.append(sum % 2);
            }
        }

        return result.reverse().toString();
    }
}
