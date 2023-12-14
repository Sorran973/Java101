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
        int n = 2;
        PalindromeLinkedList.ListNode[] arr1 = new PalindromeLinkedList.ListNode[n];

        arr1[0] = new PalindromeLinkedList.ListNode(1);
        arr1[1] = new PalindromeLinkedList.ListNode(2);
//        arr1[2] = new PalindromeLinkedList.ListNode(2);
//        arr1[3] = new PalindromeLinkedList.ListNode(1);

        for (int i = 0; i < n-1; i++) {
            arr1[i].next = arr1[i+1];
        }
        System.out.println(new PalindromeLinkedList().isPalindromeViaList(arr1[0]));
    }
}
