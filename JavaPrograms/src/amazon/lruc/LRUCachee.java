package amazon.lruc;

import java.util.HashMap;
import java.util.Map;

class LRUCachee {
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    private static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    public LRUCachee(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0); tail = new Node(0, 0);
        head.next = tail; tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        insertToFront(node);
        map.put(key, node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

