package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem28Test {

    @ParameterizedTest
    @MethodSource("testCases")
    void strStr(String haystack, String needle, int expected) {
        // given
        Problem28 problem28 = new Problem28();

        // when
        int result = problem28.strStr(haystack, needle);

        // then
        assertEquals(expected, result);
    }

    public static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of("sadbutsad", "sad", 0),
            Arguments.of("leetcode", "leeto", -1),
            Arguments.of("a", "a", 0),
            Arguments.of("abc", "c", 2),
            Arguments.of("abcd", "cd", 2),
//            Arguments.of("", "", 0),
//            Arguments.of("hello", "", 0),
//            Arguments.of("", "a", -1),
            Arguments.of("hello", "ll", 2),
            Arguments.of("aaaaa", "bba", -1),
            Arguments.of("mississippi", "issip", 4),
            Arguments.of("aaa", "aaaa", -1),
            Arguments.of("ababcaababcaabc", "ababcaabc", 6),
            Arguments.of("aabaaabaaac", "aabaaac", 4),
            Arguments.of("hello", "hello", 0),
            Arguments.of("hello", "world", -1),
            Arguments.of("abcabcabc", "abc", 0),
            Arguments.of("abcabcabc", "cab", 2)
        );
    }
}
