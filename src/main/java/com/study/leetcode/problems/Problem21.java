package com.study.leetcode.problems;

import com.study.leetcode.common.ListNode;

public class Problem21 {

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                tail = tail.next;
                p1 = p1.next;

            } else {
                tail.next = p2;
                tail = tail.next;
                p2 = p2.next;
            }
        }

        if (p1 != null) {
            tail.next = p1;
        } else if (p2 != null) {
            tail.next = p2;
        }

        System.out.println("result: " + dummy.next);
        return dummy.next;
    }
}
