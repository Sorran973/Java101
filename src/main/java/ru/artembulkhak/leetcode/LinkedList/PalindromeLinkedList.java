package ru.artembulkhak.leetcode.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 */

public class PalindromeLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean isPalindromeTwoPointersAndReverse(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while (slow.next != null) {
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        slow.next = prev;


        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }

        return true;
    }


    public boolean isPalindromeViaList(ListNode head) {
        if (head == null) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        list.add(head.val);

        while (head.next != null) {
            head = head.next;
            list.add(head.val);
        }

        int firstPointer = 0;
        int secondPointer = list.size() - 1;

        while (firstPointer < secondPointer) {
            if (!list.get(firstPointer).equals(list.get(secondPointer))) {
                return false;
            } else {
                firstPointer++;
                secondPointer--;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int n = 3;
        PalindromeLinkedList.ListNode[] arr1 = new PalindromeLinkedList.ListNode[n];

        arr1[0] = new PalindromeLinkedList.ListNode(1);
        arr1[1] = new PalindromeLinkedList.ListNode(2);
        arr1[2] = new PalindromeLinkedList.ListNode(1);
//        arr1[3] = new PalindromeLinkedList.ListNode(1);
//        arr1[4] = new PalindromeLinkedList.ListNode(5);
//        arr1[5] = new PalindromeLinkedList.ListNode(4);
//        arr1[6] = new PalindromeLinkedList.ListNode(3);
//        arr1[7] = new PalindromeLinkedList.ListNode(2);
//        arr1[8] = new PalindromeLinkedList.ListNode(1);


        for (int i = 0; i < n-1; i++) {
            arr1[i].next = arr1[i+1];
        }
        System.out.println(new PalindromeLinkedList().isPalindromeTwoPointersAndReverse(arr1[0]));
    }
}
