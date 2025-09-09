package datastructures.linkedlists;

public class MyOwnLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public MyOwnLinkedList() {
        this.head = null;
        this.size =0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int value) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
        size++;
    }

    public void addAt(int value, int index) {
        Node newNode = new Node(value);

        if (index == 0) {
            addFirst(value);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public void removeFirst() {
        head = head.next;
        size--;
    }

    public void removeLast() {
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void removeAt(int index) {
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Index Out of Bound Exception");
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }

    }

    public int getMiddle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.value;
    }

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                hasCycle = true;
        }


        return hasCycle;
    }

    public void reverse(){
        Node next;
        Node current = head;
        Node prev = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public int kthNodeFromStart(int k){
        Node current = head;

        for(int i=1;i<k;i++){
            current = current.next;
        }
        return current.value;
    }

    public int kthNodeFromEnd(int k){
        Node current = head;
        int target = size-k;

        for(int i=0;i<target;i++){
            current = current.next;
        }
        return current.value;
    }


    public void display() {
        Node current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println("]");
    }


    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
