package tree;

import java.util.Scanner;

public class TestBST {

    // use inorder traversal to find k-th smallest
    static int count=0;
    static int result = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner("10 5 3 7 15 12 20 -1");
        CustomBinarySearchTree<Integer> bst = new CustomBinarySearchTree<>(sc, Integer::parseInt);

        System.out.println("=== Tree Structure ===");
        bst.printTreeStructure();
        System.out.println("=== In Order Structure ===");
        bst.displayInOrder();
        System.out.println("=== Pre Order Structure ===");
        bst.displayPreOrder();
        System.out.println("=== Post Order Structure ===");
        bst.displayPostOrder();
        bst.delete(15);
        bst.printTreeStructure();

        System.out.println(bst.search(109));

        System.out.println("Kth Largest: "+bst.getKthLargest(2));
        System.out.println("Kth Smallest: "+bst.getKthSmallest(2));



        Scanner sc1 = new Scanner("Baba Gooba Malgooba Vakay Amma -1");
        CustomBinarySearchTree<String> bst1 = new CustomBinarySearchTree<>(sc1, String::valueOf);

        System.out.println("=== String Tree Structure ===");
        bst1.printTreeStructure();
        System.out.println("=== In Order Structure ===");
        bst1.displayInOrder();
        System.out.println("=== Pre Order Structure ===");
        bst1.displayPreOrder();
        System.out.println("=== Post Order Structure ===");
        bst1.displayPostOrder();
        System.out.println(bst1.search("Gooba"));
        bst1.delete("Malgooba");
        bst1.printTreeStructure();

        System.out.println("Kth Largest: "+bst1.getKthLargest(2));
        System.out.println("Kth Smallest: "+bst1.getKthSmallest(1));


    }

}

