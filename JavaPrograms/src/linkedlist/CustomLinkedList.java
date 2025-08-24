package linkedlist;

public class CustomLinkedList<T> {

    private Node<T> head;
    private int size;


    public CustomLinkedList() {
        head = null;
        size = 0;

    }

    public int size() {
        return size;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {

            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addAt(int index, T data) {
        checkIndex(index);

        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {

            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    public void removeAt(int index) {
        checkIndex(index);

        if (index == 0) {
            head = head.next;
        } else {

            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;
        }

        size--;
    }

    public T get(int index) {
        checkIndex(index);

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }


    public void reverse() {
        Node<T> current = head;
        Node<T> prev = null;
        Node<T> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void display() {
        Node<T> current = head;
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


    public T getMiddle() {
        Node<T> left = head;
        Node<T> right = head;

        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        return (left != null) ? left.data : null;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
