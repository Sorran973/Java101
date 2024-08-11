package ru.artembulkhak.leetcode.HashMap;

/**
 * https://leetcode.com/problems/design-hashmap/
 */

public class DesignHashMap {

    static class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private int size;
    private int capacity = 4;
    private float loadFactor = 0.75f;
    private int threshold;
    private Node[] table;
    private Node[] newTable;


    public DesignHashMap() {
        this.size = 0;
        this.table = new Node[capacity];
        this.threshold = (int) (capacity * loadFactor);
    }

    private void increaseCapacity() {
        this.capacity = this.capacity << 1;
        this.threshold = (int) (capacity * loadFactor);
        rehashTable();
    }

    private void getIntoNode(Node node) {
        if (node.getNext() != null) {
            getIntoNode(node.getNext());
        }

        int hash = hash(node.getKey());
        int index = hash % capacity;
        Node prev = newTable[index];
        newTable[index] = node;
        node.setNext(prev);
    }

    private void rehashTable() {
        newTable = new Node[capacity];

        for (int i = 0; i < table.length; i++) {
            Node node;
            if ((node = table[i]) != null) {
                    getIntoNode(node);
            }
        }

        table = newTable;
    }

    private int hash(int key) {
        return Math.abs(key * 12582917);
    }

    public void put(int key, int value) {
        if (size == threshold) {
            increaseCapacity();
        }

        Node node;
        if ((node = getNode(key)) == null) {
            int index = hash(key) % capacity;
            table[index] = new Node(key, value, table[index]);
            size += 1;
        } else {
            node.setValue(value);
        }
    }

    public Node getNode(int key) {
        int hash = hash(key);
        int index = hash % capacity;
        Node node = table[index];
        for (; node != null; node = node.getNext()) {
            if (node.getKey() == key) {
                return node;
            }
        }

        return node;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.getValue();
    }

    public void remove(int key) {
        int hash = hash(key);
        int index = hash % capacity;
        Node current = table[index];
        Node prev = current;
        boolean found = false;
        for (; current != null; current = current.getNext()) {
            if (current.getKey() == key) {
                found = true;
                break;
            }

            prev = current;
        }

        // if desired node is found
        if (found) {
            // if desired node is a head
            if (prev == current) {
                Node next;
                // if desired node is the head but there are other nodes
                if ((next = current.getNext()) != null) {
                    table[index] = next;
                } else { // if LL has only a head
                    table[index] = null;
                }
            // if desired node is not the head
            } else {
                Node next;
                if ((next = current.getNext()) != null) {
                    prev.setNext(next);
                } else {
                    prev.setNext(null);
                }
            }
        // if desired node is not found
        } else {
            return;
        }

        size -= 1;
    }


    public static void main(String[] args) {
        DesignHashMap myHashMap = new DesignHashMap();
//        myHashMap.put(1, 1); // The map is now [[1,1]]
//        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
//        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
//        System.out.println(myHashMap.get(3));   // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
//        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
//        System.out.println(myHashMap.get(2));  // return 1, The map is now [[1,1], [2,1]]
//        myHashMap.put(6, 1);
//        myHashMap.remove(6); // remove the mapping for 2, The map is now [[1,1]]
//        System.out.println(myHashMap.get(2)); // return -1 (i.e., not found), The map is now [[1,1]]

//        "MyHashMap","remove","get","put","put","put","get","put","put","put","put"]
//                  [[],[14],[4],[7,3],[11,1],[12,1],[7],[1,19],[0,3],[1,8],[2,6]]

        myHashMap.remove(14);
        System.out.println(myHashMap.get(4));
        myHashMap.put(7, 3);
        myHashMap.put(11, 1);
        myHashMap.put(12, 1);
        System.out.println(myHashMap.get(7));
        myHashMap.put(1, 19);
        myHashMap.put(0, 3);
        myHashMap.put(1, 8);
        myHashMap.put(2, 6);



    }
}
