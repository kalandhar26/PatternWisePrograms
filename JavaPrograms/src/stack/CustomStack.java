package stack;

// Used LinkedList
public class CustomStack<T> {


    private Node<T> top;
    private int size;


    CustomStack() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Push element into the Stack
    public void push(T data) {
        Node<T> newNode = new Node<>(data);

        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new StackOverflowError("Stack is empty");
        }

        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new StackOverflowError("Stack is empty");
        }

        return top.data;
    }




    public void display() {
        Node<T> current = top;
        System.out.print("[");

        while (current != null) {
            System.out.print(current.data);
            if(current.next != null){
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

    // ===== Node class ========
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Node class ends

}
