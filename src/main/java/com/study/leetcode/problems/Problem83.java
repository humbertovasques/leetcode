package com.study.leetcode.problems;

import com.study.leetcode.common.ListNode;

public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;

        while (tail.next != null) {
            if (tail.val == tail.next.val) {
                tail.next = tail.next.next;
            } else {
                tail = tail.next;
            }
        }

        return head;
    }
}
