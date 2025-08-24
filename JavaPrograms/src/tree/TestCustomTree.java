package tree;

import java.util.Scanner;

public class TestCustomTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner("1 2 4 -1 -1 -1 3 5 -1 -1 6 -1 -1");
        CustomBinaryTree<Integer> tree = new CustomBinaryTree<>(sc,Integer::parseInt);

        System.out.println("===Pre Order===");
        tree.displayPreOrder(); // 1,2,4,3,5,6
        System.out.println("===In Order===");
        tree.displayInOrder(); // 4,2,1,5,3,6
        System.out.println("===Post Order===");
        tree.displayPostOrder(); // 4,2,5,6,3,1
        System.out.println("==== Level Order ====");
        tree.displayLevelOrder();
        tree.printTreeStructure();

        Scanner sc1 = new Scanner("Baba Gooba Kaliba Vankay Bendakaya Dondakaya Mirakay");
        CustomBinaryTree<String> tree1 = new CustomBinaryTree<>(sc1,String::valueOf);
        System.out.println("===Pre Order===");
        tree1.displayPreOrder(); // 1,2,4,3,5,6
        System.out.println("===In Order===");
        tree1.displayInOrder(); // 4,2,1,5,3,6
        System.out.println("===Post Order===");
        tree1.displayPostOrder(); // 4,2,5,6,3,1
        System.out.println("==== Level Order ====");
        tree1.displayLevelOrder();

        tree1.printTreeStructure();
    }
}
