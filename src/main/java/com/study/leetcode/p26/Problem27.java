package com.study.leetcode.p26;

public class Problem27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        nums[j] = val;
                        count--;
                        break;
                    }
                }
                count++;
            }
        }

        return nums.length - count;
    }
}
