package com.study.leetcode.problems;

import com.study.leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Problem83Test {

    @ParameterizedTest
    @MethodSource("deleteDuplicatesSource")
    void deleteDuplicates(int[] arr, int[] expected) {
        // Given
        ListNode input = ListNode.buildList(arr);
        Problem83 p83 = new Problem83();

        // When
        ListNode output = p83.deleteDuplicates(input);

        // Then
        int[] result = ListNode.toArray(output);
        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> deleteDuplicatesSource() {
        return Stream.of(
            arguments(new int[]{1,1,2}, new int[]{1, 2}),
            arguments(new int[]{1,1,2,3,3}, new int[]{1, 2, 3}),
            arguments(new int[]{-1, 0, 0, 0, 0, 3, 3}, new int[]{-1, 0, 3})
        );
    }
}
