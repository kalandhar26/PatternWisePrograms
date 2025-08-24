package amazon.linkedlist;

public class AmazonLinkedList {

    Node head;
    int size;

    AmazonLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;

            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }
        size++;
    }

    public void addAt(int data, int index) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node currentNode = head;

            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        size++;
    }


    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void display() {
        Node current = head;
        System.out.print("[");

        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }

        System.out.println("]");

    }

    public void reverseRecur() {
       this.head = reverseRecursive(head);
    }

    private Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public void reverseIter() {
       this.head = reverseIterative(head);
    }

    private Node reverseIterative(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;

    }


    public int getMiddle() {
        Node left = head;
        Node right = head;

        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        return (left!= null) ? left.data : null;
    }

    public boolean hasCycle(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
}
