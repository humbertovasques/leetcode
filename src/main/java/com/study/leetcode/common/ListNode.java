package com.study.leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }

    public static ListNode buildList(int[] values) {
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
    public static int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
