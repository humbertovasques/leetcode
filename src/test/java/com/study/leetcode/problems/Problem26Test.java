package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Arrays.copyOf;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem26Test {

    @ParameterizedTest
    @MethodSource("testCases")
    void removeDuplicates(int[] nums, int expected, int[] expectedArray) {
        int result = Problem26.removeDuplicates(nums);
        assertEquals(expected, result);
        assertArrayEquals(expectedArray, copyOf(nums, result));
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{}, 0, new int[]{}),
            Arguments.of(new int[]{1}, 1, new int[]{1}),
            Arguments.of(new int[]{1, 1}, 1, new int[]{1}),
            Arguments.of(new int[]{1, 2}, 2, new int[]{1, 2}),
            Arguments.of(new int[]{1, 1, 2}, 2, new int[]{1, 2}),
            Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5, new int[]{0, 1, 2, 3, 4}),
            Arguments.of(new int[]{-3, -3, -2, -1, -1, 0}, 4, new int[]{-3, -2, -1, 0}),
            Arguments.of(new int[]{1, 1, 1, 1, 1}, 1, new int[]{1})
        );
    }
}
