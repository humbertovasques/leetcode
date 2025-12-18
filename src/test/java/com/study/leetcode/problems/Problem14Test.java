package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem14Test {

    @ParameterizedTest
    @MethodSource("longestCommonPrefixSource")
    public void longestCommonPrefix(String[] input, String expectedResult) {
        // Given
        Problem14 p14 = new Problem14();

        // When
        String result = p14.longestCommonPrefix(input);

        // Then
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> longestCommonPrefixSource() {
        return Stream.of(
          Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
          Arguments.of(new String[]{"dog", "racecar", "car"}, "")
        );
    }
}
