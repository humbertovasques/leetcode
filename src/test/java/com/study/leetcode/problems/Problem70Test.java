package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem70Test {

    @ParameterizedTest
    @MethodSource("climbStairsSource")
    void climbStairs(int input, int expectedResult) {
        // given
        Problem70 problem70 = new Problem70();

        // when
        int result = problem70.climbStairs(input);

        // then
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> climbStairsSource() {
        return Stream.of(
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(3, 3),
            Arguments.of(4, 5),
            Arguments.of(5, 8),
            Arguments.of(6, 13),
            Arguments.of(7, 21),
            Arguments.of(8, 34),
            Arguments.of(9, 55),
            Arguments.of(10, 89),
            Arguments.of(11, 144),
            Arguments.of(12, 233),
            Arguments.of(13, 377),
            Arguments.of(14, 610),
            Arguments.of(15, 987),
            Arguments.of(16, 1597),
            Arguments.of(17, 2584),
            Arguments.of(18, 4181),
            Arguments.of(19, 6765),
            Arguments.of(20, 10946),
            Arguments.of(21, 17711),
            Arguments.of(22, 28657),
            Arguments.of(23, 46368),
            Arguments.of(24, 75025),
            Arguments.of(25, 121393),
            Arguments.of(26, 196418),
            Arguments.of(27, 317811),
            Arguments.of(28, 514229),
            Arguments.of(29, 832040),
            Arguments.of(30, 1346269),
            Arguments.of(31, 2178309),
            Arguments.of(32, 3524578),
            Arguments.of(33, 5702887),
            Arguments.of(34, 9227465),
            Arguments.of(35, 14930352),
            Arguments.of(36, 24157817),
            Arguments.of(37, 39088169),
            Arguments.of(38, 63245986),
            Arguments.of(39, 102334155),
            Arguments.of(40, 165580141),
            Arguments.of(41, 267914296),
            Arguments.of(42, 433494437),
            Arguments.of(43, 701408733),
            Arguments.of(44, 1134903170),
            Arguments.of(45, 1836311903)
        );
    }
}
