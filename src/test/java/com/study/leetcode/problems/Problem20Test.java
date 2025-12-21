//You are given the heads of two sorted linked lists list1 and list2.
//
// Merge the two lists into one sorted list. The list should be made by
//splicing together the nodes of the first two lists.
//
// Return the head of the merged linked list.
//
//
// Example 1:
//
//
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//
//
// Example 2:
//
//
//Input: list1 = [], list2 = []
//Output: []
//
//
// Example 3:
//
//
//Input: list1 = [], list2 = [0]
//Output: [0]
//
//
//
// Constraints:
//
//
// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both list1 and list2 are sorted in non-decreasing order.
//
//
// Related Topics Linked List Recursion


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
package com.study.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem20Test {

    @ParameterizedTest
    @MethodSource("validParenthesesCases")
    void isValid(String input, boolean expected) {
        // Given
        Problem20 p20 = new Problem20();

        // When
        boolean result = p20.isValid(input);

        // Then
        assertEquals(expected, result);
    }

    static Stream<Arguments> validParenthesesCases() {
        return Stream.of(
            // Casos básicos
            Arguments.of("()", true),
            Arguments.of("()[]{}", true),
            Arguments.of("(]", false),
            Arguments.of("([])", true),
            Arguments.of("([)]", false),

            // Um único par de cada tipo
            Arguments.of("[]", true),
            Arguments.of("{}", true),

            // Começa com fechamento
            Arguments.of(")", false),
            Arguments.of("]", false),
            Arguments.of("}", false),

            // Apenas aberturas / apenas fechamentos
            Arguments.of("((((", false),
            Arguments.of("))))", false),
            Arguments.of("{{{{", false),
            Arguments.of("}}}}", false),
            Arguments.of("[[[[", false),
            Arguments.of("]]]]", false),

            // Falta fechamento
            Arguments.of("(", false),
            Arguments.of("([]", false),
            Arguments.of("({}", false),
            Arguments.of("()[{}", false),

            // Falta abertura
            Arguments.of(")(", false),
            Arguments.of("]()", false),
            Arguments.of("}{}", false),
            Arguments.of("(])", false),

            // Aninhamentos corretos mais profundos
            Arguments.of("{[()]}", true),
            Arguments.of("[({})]", true),
            Arguments.of("(([]){})", true),
            Arguments.of("()[{}]", true),
            Arguments.of("({}[])", true),
            Arguments.of("()()()()", true),

            // Erros sutis em estruturas aninhadas
            Arguments.of("{[(])}", false),
            Arguments.of("[({})](]", false),
            Arguments.of("(([]){})]", false),
            Arguments.of("({}[])(", false)
        );
    }
}
