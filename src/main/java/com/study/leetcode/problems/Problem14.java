package com.study.leetcode.problems;

// TODO: Refatorar quando refazer esse problema
// 14. Longest Common Prefix
public class Problem14 {
    public static void main(String[] args) {
        System.out.println("output: " + longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println("output: " + longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int indexOf = strs[i].indexOf(prefix);
            while (indexOf != 0 ) {
                prefix = prefix.substring(0, prefix.length() - 1); // Quando beginIndex = endIndex no substring o retorno eh ""
                indexOf = strs[i].indexOf(prefix);
            }
        }
        return prefix;
    }
}
