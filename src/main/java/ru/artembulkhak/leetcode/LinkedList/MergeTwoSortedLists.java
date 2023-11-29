package ru.artembulkhak.leetcode.LinkedList;


/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */

public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        ListNode currentNode = null;

        if (list1 == null && list2 == null) {
            return currentNode;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.val < list2.val) {
                currentNode = list1;
                if (list1.next != null) {
                    currentNode.next = mergeTwoListsRecursion(list1.next, list2);
                } else {
                    currentNode.next = mergeTwoListsRecursion(null, list2);
                }
            } else {
                currentNode = list2;
                if (list2.next != null) {
                    currentNode.next = mergeTwoListsRecursion(list1, list2.next);
                } else {
                    currentNode.next = mergeTwoListsRecursion(list1, null);
                }
            }
        }

        return currentNode;
    }

    public ListNode mergeTwoListsDummy(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-100);
        ListNode currentNode = dummy;
        boolean flag;

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            while (true) {
                if (list1.val < list2.val) {
                    currentNode.next = list1;
                    if (list1.next != null) {
                        list1 = list1.next;
                    } else {
                        flag = true;
                        break;
                    }
                } else {
                    currentNode.next = list2;
                    if (list2.next != null) {
                        list2 = list2.next;
                    } else {
                        flag = false;
                        break;
                    }
                }

                currentNode = currentNode.next;

            }
        }

        currentNode = currentNode.next;

        if (flag) {
            currentNode.next = list2;
        } else {
            currentNode.next = list1;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        int n = 3, m = 3;
        ListNode[] arr1 = new ListNode[n];
        ListNode[] arr2 = new ListNode[m];

        arr1[0] = new ListNode(1);
        arr1[1] = new ListNode(2);
        arr1[2] = new ListNode(4);
        for (int i = 0; i < n-1; i++) {
            arr1[i].next = arr1[i+1];
        }

        arr2[0] = new ListNode(1);
        arr2[1] = new ListNode(3);
        arr2[2] = new ListNode(4);
        for (int i = 0; i < m-1; i++) {
            arr2[i].next = arr2[i+1];
        }

//        new MergeTwoSortedLists().mergeTwoListsRecursion(arr1[0], arr2[0]);
        new MergeTwoSortedLists().mergeTwoListsDummy(arr1[0], arr2[0]);
    }
}
