package ru.artembulkhak.leetcode.LinkedList;


public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode firstPointer = null; // dummy node
        ListNode secondPointer = head;

        while (secondPointer != null) {
            if (secondPointer.next != null) {
                ListNode thirdPointer = secondPointer.next;
                secondPointer.next = firstPointer;

                firstPointer = secondPointer;
                secondPointer = thirdPointer;
            } else {
                secondPointer.next = firstPointer;
                return secondPointer;
            }
        }

        return secondPointer;
    }

    public ListNode recursion(ListNode head, ListNode previous) {

        if (head == null) {
            return null;
        }

        ListNode first;

        if (head.next != null) {
            first = recursion(head.next, head);
            head.next = previous;
            return first;
        } else {
            head.next = previous;
            return  head;
        }
    }

    public ListNode reverseListRecursion(ListNode head) {
        return recursion(head, null);
    }

    public static void main(String[] args) {
        int n = 5;
        ListNode[] arr = new ListNode[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(i);
        }
        for (int i = 0; i < n-1; i++) {
            arr[i].next = arr[i+1];
        }

//        System.out.println(new ReverseLinkedList().reverseList(arr[0]));
        System.out.println(new ReverseLinkedList().reverseListRecursion(arr[0]));

    }
}
