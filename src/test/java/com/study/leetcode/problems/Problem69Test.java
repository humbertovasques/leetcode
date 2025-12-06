package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem69Test {

    @ParameterizedTest
    @MethodSource("mySqrtSource")
    void mySqrt(int input, int expectedResult) {
        // given
        Problem69 problem69 = new Problem69();

        // when
        int result = problem69.mySqrt(input);

        // then
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> mySqrtSource() {
        return Stream.of(
            Arguments.of(0, 0),
            Arguments.of(1, 1),
            Arguments.of(2, 1),
            Arguments.of(3, 1),
            Arguments.of(4, 2),
            Arguments.of(8, 2),
            Arguments.of(9, 3),
            Arguments.of(15, 3),
            Arguments.of(16, 4),
            Arguments.of(25, 5),
            Arguments.of(2147395599, 46339),
            Arguments.of(2147483647, 46340)
        );
    }
}
