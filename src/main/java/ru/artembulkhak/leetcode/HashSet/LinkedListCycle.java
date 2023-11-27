package ru.artembulkhak.leetcode.HashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
https://leetcode.com/problems/linked-list-cycle/description/
*/

public class LinkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycleHashSet(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> hashSet = new HashSet<>();
        ListNode currentNode = head;

        while (currentNode.next != null) {
            if (!hashSet.add(currentNode)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public boolean hasCycleTwoPointers(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        if (slow == null) {
            return false;
        }

        do {
             if (slow.next != null && fast.next.next != null) {
                 slow = slow.next;
                 fast = fast.next.next;
             } else {
                 return false;
             }
        } while (slow != fast);

        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        List<ListNode> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(new ListNode(i));
        }
        for (int i = 0; i < n - 1; i++) {
            arrayList.get(i).next = arrayList.get(i+1);
        }
        arrayList.get(4).next = arrayList.get(4);


        System.out.println(new LinkedListCycle().hasCycleHashSet(arrayList.get(0)));
        System.out.println(new LinkedListCycle().hasCycleTwoPointers(arrayList.get(0)));
    }
}
