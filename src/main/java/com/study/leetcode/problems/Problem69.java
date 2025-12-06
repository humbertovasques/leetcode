package com.study.leetcode.problems;

public class Problem69 {
    public int mySqrt(int x) {
        // Handle small values directly.
        if (x < 2) {
            return x; // sqrt(0) = 0, sqrt(1) = 1
        }

        int left = 1;
        int right = x / 2;

        // Loop invariant:
        // At the beginning of each iteration,
        // floor(sqrt(x)) is guaranteed to lie in the interval [left, right].
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int div = x / mid; // equivalent to floor(x / mid), used to avoid mid * mid overflow

            if (mid == div) {
                // mid * mid == x  →  we found the exact square root.
                return mid;
            } else if (mid < div) {
                // mid * mid < x  →  mid is too small, but still a valid candidate.
                // So the answer is in [mid + 1, right].
                left = mid + 1;
            } else {
                // mid * mid > x  →  mid is too large.
                // So the answer is in [left, mid - 1].
                right = mid - 1;
            }
            // After this update, the invariant still holds: sqrt(x) ∈ [left, right].
        }

        // When the loop ends, left has crossed right.
        // At this point, right is the largest value such that right * right <= x,
        // i.e., floor(sqrt(x)).
        return right;
    }
}
