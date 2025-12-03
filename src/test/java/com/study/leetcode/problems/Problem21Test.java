package com.study.leetcode.problems;

import com.study.leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Problem21Test {

    @ParameterizedTest
    @MethodSource("provideListsForMerge")
    void mergeTwoLists_shouldMergeCorrectly(int[] arr1, int[] arr2, int[] expected) {
        // given
        ListNode list1 = buildList(arr1);
        ListNode list2 = buildList(arr2);
        Problem21 solution = new Problem21();

        // when
        ListNode merged = solution.mergeTwoLists(list1, list2);

        // then
        int[] result = toArray(merged);
        assertArrayEquals(expected, result);
    }

    // --- Cenários de teste ---
    static Stream<Arguments> provideListsForMerge() {
        return Stream.of(
            // Exemplo 1 do enunciado
            arguments(
                new int[]{1, 2, 4},
                new int[]{1, 3, 4},
                new int[]{1, 1, 2, 3, 4, 4}
            ),
            // Exemplo 2: ambos vazios
            arguments(
                new int[]{},
                new int[]{},
                new int[]{}
            ),
            // Exemplo 3: primeiro vazio, segundo com 1 elemento
            arguments(
                new int[]{},
                new int[]{0},
                new int[]{0}
            ),
            // list1 inteira menor que list2
            arguments(
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{1, 2, 3, 4, 5, 6}
            ),
            // list2 inteira menor que list1
            arguments(
                new int[]{4, 5, 6},
                new int[]{1, 2, 3},
                new int[]{1, 2, 3, 4, 5, 6}
            ),
            // valores negativos e repetidos
            arguments(
                new int[]{-3, -1, 2},
                new int[]{-2, 0, 2},
                new int[]{-3, -2, -1, 0, 2, 2}
            ),
            // muitos duplicados
            arguments(
                new int[]{1, 1, 1},
                new int[]{1, 1},
                new int[]{1, 1, 1, 1, 1}
            )
        );
    }

    // --- Helpers para o teste ---

    // Constrói uma lista encadeada a partir de um array
    private static ListNode buildList(int[] values) {
        ListNode head = null;
        ListNode tail = null;

        for (int v : values) {
            ListNode node = new ListNode(v);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

    // Converte uma lista encadeada em um array para facilitar o assert
    private static int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
