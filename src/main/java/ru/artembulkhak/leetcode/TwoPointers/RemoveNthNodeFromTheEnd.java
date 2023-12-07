package ru.artembulkhak.leetcode.TwoPointers;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */

public class RemoveNthNodeFromTheEnd {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // O(list.length)
    public ListNode removeNthFromEndWithTwoPointers(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        if (fast.next == null) {
            return head.next;
        }

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    // O(2 * list.length = list.length)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currentNode = head;
        int index = 1;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            index++;
        }

        currentNode = head;
        if (index == n) {
            return head.next;
        } else {
            for (int i = 1; i < index - n; i++) {
                currentNode = currentNode.next;
            }
        }

        ListNode removedNode = currentNode.next;
        ListNode nextNode = removedNode.next;
        currentNode.next = nextNode;

        return head;
    }


    public static void main(String[] args) {
        int n = 2;
        ListNode[] arr = new ListNode[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(i+1);
        }
        if (n - 1 == 0) {
            arr[0].next = null;
        } else {
            for (int i = 0; i < n - 1; i++) {
                arr[i].next = arr[i + 1];
            }
        }

        new RemoveNthNodeFromTheEnd().removeNthFromEnd(arr[0], 2);
    }
}
