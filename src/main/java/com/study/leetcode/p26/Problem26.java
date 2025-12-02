package com.study.leetcode.p26;

public class Problem26 {
    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = {2,1,2};
//        int[] nums = {-3,-3,-2,-1,-1,0};
//        int k = removeDuplicates(nums);
//        System.out.println(k + " " + Arrays.toString(nums));
        int x = -1;

// I expect x to never be negative
        assert x >= 0 : "x should never be negative, but was " + x;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
