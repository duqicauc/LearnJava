package org.java.learn.ds.addtwosum;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carray = 0;
        ListNode resHead = new ListNode(0);
        ListNode tail = resHead;
        do {
            int curr = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            ListNode temp = new ListNode((curr + carray) % 10);
            carray = (curr + carray) / 10;

            tail.next = temp;
            tail = temp;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        } while (l1 != null || l2 != null || carray != 0);

        return resHead.next;
    }
}

