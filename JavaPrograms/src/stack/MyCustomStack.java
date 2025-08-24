package stack;

public class MyCustomStack<T> {

    private Object[] elements;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public MyCustomStack() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.top = -1;
    }

    public MyCustomStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        this.elements = new Object[capacity];
        this.top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void checkCapacity() {
        double loadFactor = (double) size() / elements.length;

        if (loadFactor >= 0.75) {
            Object[] newElements = new Object[2 * elements.length];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    public void push(T element) {
        checkCapacity();
        elements[++top] = element;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        T value = (T) elements[top];
        elements[top] = null;
        top--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return (T) elements[top];
    }

    public void display() {
        System.out.print("[");
        for (int i = top; i >= 0; i--) {
            System.out.print(elements[i]);
            if (i>0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
