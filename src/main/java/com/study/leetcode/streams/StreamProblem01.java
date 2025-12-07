package com.study.leetcode.streams;

import java.util.Arrays;

public class StreamProblem01 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6};
        System.out.println(sumOfEven(nums)); // 12
    }

    public static int sumOfEven(int[] nums) {
        return Arrays.stream(nums)
            .filter(n -> n % 2 == 0)
            .sum();
    }
}
