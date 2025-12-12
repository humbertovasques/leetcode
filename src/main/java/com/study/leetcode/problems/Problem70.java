package com.study.leetcode.problems;

public class Problem70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prev2 = 1, prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public int climbStairsV1(int n) {
        // S = C(n,0) + C(n-1,1) + C(n-2,2) + ... + C(n-n/2,n/2)
        int sum = 0;
        for (int i = 0; i <= n / 2; i++) {
            sum += combination(n - i, i);
        }

        return sum;
    }

    private int combination(int n, int p) {
        long result = 1;
        for (int i = 0; i < p; i++){
            result = result * (n - i) / (i + 1);
        }
        return (int)result;
    }
}

//You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//Example 1:
//
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//Example 2:
//
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
//Constraints:
//
//    1 <= n <= 45
//Related Topics
//Math
//Dynamic Programming
//Memoization
