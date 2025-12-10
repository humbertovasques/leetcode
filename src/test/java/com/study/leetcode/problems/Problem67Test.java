package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem67Test {

    @ParameterizedTest
    @MethodSource("addBinarySource")
    void addBinary(String inputA, String inputB, String expectedResult) {
        // given
        Problem67 problem67 = new Problem67();

        // when
        String result = problem67.addBinary(inputA, inputB);

        // then
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> addBinarySource() {
        return Stream.of(
            Arguments.of("11", "1", "100"),
            Arguments.of("1010", "1011", "10101")
        );
    }
}
