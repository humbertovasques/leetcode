package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Problem5Test {

    @ParameterizedTest
    @MethodSource("longestPalindromeCases")
    void longestPalindrome(String input, int expectedLength, Set<String> expectedOutputs) {
        Problem5 problem = new Problem5();

        String actual = problem.longestPalindrome(input);

        assertNotNull(actual);
        assertTrue(input.contains(actual));
        assertTrue(isPalindrome(actual));
        assertEquals(expectedLength, actual.length());
        if (!expectedOutputs.isEmpty()) {
            assertTrue(expectedOutputs.contains(actual));
        }
    }

    static Stream<Arguments> longestPalindromeCases() {
        return Stream.of(
                Arguments.of("babad", 3, setOf("bab", "aba")),
                Arguments.of("cbbd", 2, setOf("bb")),
                Arguments.of("a", 1, setOf("a")),
                Arguments.of("ac", 1, setOf("a", "c")),
                Arguments.of("aaaa", 4, setOf("aaaa")),
                Arguments.of("abba", 4, setOf("abba")),
                Arguments.of("12321", 5, setOf("12321"))
        );
    }

    private static Set<String> setOf(String... values) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(values)));
    }

    private boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int max = s.length() - 1;
        for (int i = 0; i <= max / 2; i++) {
            if (s.charAt(i) != s.charAt(max - i)) {
                return false;
            }
        }
        return true;
    }
}
