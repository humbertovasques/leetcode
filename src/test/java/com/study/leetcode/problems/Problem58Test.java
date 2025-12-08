package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem58Test {

    @ParameterizedTest
    @MethodSource("lengthOfLastWordSource")
    void lengthOfLastWord(String input, int expectedOutput) {
        // given
        Problem58 problem58 = new Problem58();

        // when
        int output = problem58.lengthOfLastWord(input);

        // then
        assertEquals(expectedOutput, output);
    }

    private static Stream<Arguments> lengthOfLastWordSource() {
        return Stream.of(
            Arguments.of("Hello World", 5),
            Arguments.of("   fly me    to    the moon    ", 4),
            Arguments.of("   ", 0),
            Arguments.of("a", 1),
            Arguments.of("aa", 2),
            Arguments.of("luffy is still joyboy", 6)
        );
    }
}
