package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Arrays.sort;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Problem27Test {

    @ParameterizedTest
    @MethodSource("removeElementParams")
    void removeElement(int[] nums, int val, int[] expected) {
        // given
        Problem27 problem27 = new Problem27();

        // when
        int k = problem27.removeElement(nums, val);

        // then
        assertEquals(expected.length, k);
        sort(nums, 0, k);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }

    static Stream<Arguments> removeElementParams() {
        return Stream.of(
            arguments(
                new int[]{3,2,2,3},
                3,
                new int[]{2,2}
            ),
            arguments(
                new int[]{2},
                3,
                new int[]{2}
            ),
            arguments(
                new int[]{2,2},
                3,
                new int[]{2,2}
            ),
            arguments(
                new int[]{1},
                1,
                new int[]{}
            ),
            arguments(
                new int[]{1,1},
                1,
                new int[]{}
            ),
            arguments(
                new int[]{},
                1,
                new int[]{}
            ),
            arguments(
                new int[]{0,1,2,2,3,0,4,2},
                2,
                new int[]{0,0,1,3,4}
            )
        );
    }
}
