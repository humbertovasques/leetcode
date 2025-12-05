package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem35Test {

    @ParameterizedTest
    @MethodSource("searchInsertSource")
    void searchInsert(int[] nums, int target, int expected) {
        // given
        Problem35 problem35 = new Problem35();

        // when
        int result = problem35.searchInsert(nums, target);

        // then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> searchInsertSource() {
        return Stream.of(
            Arguments.of(new int[]{1,3,5,6}, 5, 2),
            Arguments.of(new int[]{1,3,5,6}, 2, 1),
            Arguments.of(new int[]{1,3,5,6}, 7, 4),
            Arguments.of(new int[]{1,3,4,5,6}, 7, 5)
        );
    }
}
