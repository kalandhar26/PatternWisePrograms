package tree;

import java.util.Scanner;

public class CustomBinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public CustomBinarySearchTree(Scanner sc, Parser<T> parser) {
        this.root = buildTree(sc, parser);
    }

    // Insertion Methods
    private Node<T> buildTree(Scanner sc, Parser<T> parser) {
        Node<T> root = null;
        while (sc.hasNext()) {
            String token = sc.next();
            if (token.equals("-1")) break;

            T data = parser.parse(token);
            root = insert(root, data);
        }
        return root;
    }

    private Node<T> insert(Node<T> root, T data) {
        if (root == null) {
            return new Node<>(data);
        }

        if (data.compareTo(root.data) <= 0) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Traversal Methods

    // Left, Root, Right
    private void inOrderPrint(Node<T> root) {
        if (root == null)
            return;
        inOrderPrint(root.left);
        System.out.println(root.data);
        inOrderPrint(root.right);
    }

    // Root,Left, Right
    private void preOrderPrint(Node<T> root) {
        if (root == null) return;
        System.out.println(root.data);
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    // Left, Right, Root
    private void postOrderPrint(Node<T> root) {
        if (root == null) return;
        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.println(root.data);
    }

    // Display Methods

    public void displayInOrder() {
        inOrderPrint(root);
    }

    public void displayPreOrder() {
        preOrderPrint(root);
    }

    public void displayPostOrder() {
        postOrderPrint(root);
    }

    public void printTreeStructure() {
        printTree(root, "", true);
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

    // Search Method
    private boolean isExists(Node<T> root, T data) {
        if (root == null)
            return false;

        if (root.data.equals(data))
            return true;

        if (root.data.compareTo(data) >= 0) {
            return isExists(root.left, data);
        } else {
            return isExists(root.right, data);
        }
    }


    public boolean search(T data) {
        return isExists(root, data);
    }

    // Deletion Methods
    public void delete(T key) {
        root = deleteNode(root, key);
    }

    private Node<T> deleteNode(Node<T> root, T data) {
        if (root == null) return null;

        int cmp = data.compareTo(root.data);

        if (cmp < 0) {
            root.left = deleteNode(root.left, data);
        } else if (cmp > 0) {
            root.right = deleteNode(root.right, data);
        } else {
            // This is the node to be deleted.
            // Case 1: No children
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two children
            // find the minimum node in right SubTree
            Node<T> successor = findMin(root.right);
            root.data = successor.data;
            root.right = deleteNode(root.right, successor.data);

        }

        return root;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    // Method to get the kth smallest element
    public T getKthSmallest(int k) {
        if (k <= 0 || root == null) {
            return null;
        }
        NodeWrapper<T> wrapper = new NodeWrapper<>();
        wrapper.count = 0;
        getKthSmallest(root, k, wrapper);
        return wrapper.node != null ? wrapper.node.data : null;
    }

    private void getKthSmallest(Node<T> root, int k, NodeWrapper<T> wrapper) {
        if (root == null || wrapper.count >= k) {
            return;
        }

        // Traverse left subtree first
        getKthSmallest(root.left, k, wrapper);

        // Process current node
        wrapper.count++;
        if (wrapper.count == k) {
            wrapper.node = root;
            return;
        }

        // Traverse right subtree
        getKthSmallest(root.right, k, wrapper);
    }

    // Method to get the kth largest element
    public T getKthLargest(int k) {
        if (k <= 0 || root == null) {
            return null;
        }
        NodeWrapper<T> wrapper = new NodeWrapper<>();
        wrapper.count = 0;
        getKthLargest(root, k, wrapper);
        return wrapper.node != null ? wrapper.node.data : null;
    }

    private void getKthLargest(Node<T> root, int k, NodeWrapper<T> wrapper) {
        if (root == null || wrapper.count >= k) {
            return;
        }

        // Traverse right subtree first (reverse in-order)
        getKthLargest(root.right, k, wrapper);

        // Process current node
        wrapper.count++;
        if (wrapper.count == k) {
            wrapper.node = root;
            return;
        }

        // Traverse left subtree
        getKthLargest(root.left, k, wrapper);
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

    // Helper class to keep track of count and node during traversal
    private static class NodeWrapper<T> {
        int count;
        Node<T> node;
    }
}
