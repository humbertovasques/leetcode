package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem66Test {

    @ParameterizedTest
    @MethodSource("plusOneSource")
    void plusOne(int[] input, int[] expectedResult) {
        // given
        Problem66 problem66 = new Problem66();

        // when
        int[] result = problem66.plusOne(input);

        // then
        assertEquals(expectedResult.length, result.length);
        for (int i = 0; i < expectedResult.length; i++) {
            assertEquals(expectedResult[i], result[i]);
        }
    }

    private static Stream<Arguments> plusOneSource() {
        return Stream.of(
            Arguments.of(new int[] {1,2,3}, new int[]{1,2,4}),
            Arguments.of(new int[] {4,3,2,1}, new int[]{4,3,2,2}),
            Arguments.of(new int[] {9}, new int[]{1,0}),
            Arguments.of(new int[] {0}, new int[]{1})
        );
    }
}
