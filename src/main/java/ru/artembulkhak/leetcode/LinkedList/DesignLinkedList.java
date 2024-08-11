package ru.artembulkhak.leetcode.LinkedList;

/**
 * https://leetcode.com/problems/design-linked-list/description/
 */

public class DesignLinkedList {

    static class MyNode {
        private int value;
        private MyNode next;

        public MyNode(int value) {
            this.value = value;
        }

        public MyNode getNext() {
            return next;
        }

        public void setNext(MyNode next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;


    public DesignLinkedList() {
        size = 0;
    }

    public MyNode getNode(int index) {
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            return getNode(index).getValue();
        }
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new MyNode(val);
            tail = head;
        } else {
            MyNode newHead = new MyNode(val);
            newHead.setNext(head);
            head = newHead;
        }
        size += 1;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
        } else {
            MyNode newTail = new MyNode(val);
            tail.setNext(newTail);
            tail = newTail;
            size += 1;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        } else if (index == size) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            MyNode newNode = new MyNode(val);
            MyNode prev;
            if ((prev = getNode(index - 1)) == null) {
                newNode.setNext(head);
                head = newNode;
            } else {
                MyNode current = prev.getNext();
                prev.setNext(newNode);
                newNode.setNext(current);
            }
            size += 1;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        } else if (index == 0) {
            MyNode next = head.getNext();
            head.setNext(null);
            head = next;
        } else {
            MyNode prev = getNode(index - 1);
            MyNode current = prev.getNext();
            MyNode next = current.getNext();
            prev.setNext(next);
            current.setNext(null);
            if (index == size - 1) {
                tail = prev;
            }
        }
        size -= 1;
    }

    public static void main(String[] args) {
        DesignLinkedList myLinkedList = new DesignLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(3,2);
    }
}
