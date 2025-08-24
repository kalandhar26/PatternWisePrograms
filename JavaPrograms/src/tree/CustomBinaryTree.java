package tree;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Function;

public class CustomBinaryTree<T extends Comparable<T>> {

    Node<T> root;

    public CustomBinaryTree(Scanner sc, Function<String, T> parser) {
        root = createTree(sc, parser);
    }


    private Node<T> createTree(Scanner sc, Function<String, T> parser) {
        if (!sc.hasNext()) return null;

        String token = sc.next();
        if (token.equals("-1")) return null;

        T data = parser.apply(token);
        Node<T> newNode = new Node<>(data);
        newNode.left = createTree(sc, parser);
        newNode.right = createTree(sc, parser);

        return newNode;
    }

    public void displayPreOrder() {
        preOrderPrint(root);
    }

    public void displayInOrder() {
        inOrderPrint(root);
    }

    public void displayPostOrder() {
        postOrderPrint(root);
    }

    public void displayLevelOrder() {
        levelOrderTraversal(root);
    }

    public void printTreeStructure() {
        printTree(root, "", true);
    }

    private void preOrderPrint(Node<T> root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    private void inOrderPrint(Node<T> root) {
        if (root == null) {
            return;
        }

        inOrderPrint(root.left);
        System.out.println(root.data);
        inOrderPrint(root.right);
    }

    private void postOrderPrint(Node<T> root) {
        if (root == null) {
            return;
        }

        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.println(root.data);
    }

    private void printTree(Node<T> node, String prefix, boolean isTail) {
        if (node == null) return;

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.data);

        boolean hasLeft = node.left != null;
        boolean hasRight = node.right != null;

        if (hasLeft || hasRight) {
            if (hasLeft && hasRight) {
                printTree(node.left, prefix + (isTail ? "    " : "│   "), false);
                printTree(node.right, prefix + (isTail ? "    " : "│   "), true);
            } else if (hasLeft) {
                printTree(node.left, prefix + (isTail ? "    " : "│   "), true);
            } else {
                printTree(node.right, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    // Level Order Traversal
    private void levelOrderTraversal(Node<T> root) {
        ArrayDeque<Node<T>> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<T> frontElement = queue.poll();
            System.out.println(frontElement.data);
            if (frontElement.left != null) {
                queue.offer(frontElement.left);
            }

            if (frontElement.right != null) {
                queue.offer(frontElement.right);
            }
        }
    }

    // Find Kth Largest and Smallest using heap when unsorted tree
    public T findKthLargestUsingHeap(int k) {
        PriorityQueue<T> minHeap = new PriorityQueue<>();
        fillHeap(root, minHeap, k);
        return minHeap.peek(); // Kth largest
    }

    public T findKthSmallestUsingHeap(int k) {
        PriorityQueue<T> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        fillHeap(root, maxHeap, k);
        return maxHeap.peek(); // Kth smallest
    }

    private void fillHeap(Node<T> node, PriorityQueue<T> heap, int k) {
        if (node == null) return;

        heap.offer(node.data);
        if (heap.size() > k) {
            heap.poll(); // Remove smallest to keep only k largest
        }

        fillHeap(node.left, heap, k);
        fillHeap(node.right, heap, k);
    }



    private static class Node<T> {
        Node<T> left;
        T data;
        Node<T> right;

        Node(T data) {
            this.data = data;
            left = right = null;
        }
    }
}
