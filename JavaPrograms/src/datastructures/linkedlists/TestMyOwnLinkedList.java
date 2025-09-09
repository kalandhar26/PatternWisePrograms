package datastructures.linkedlists;

public class TestMyOwnLinkedList {

    public static void main(String[] args) {

        MyOwnLinkedList linkedList = new MyOwnLinkedList();
        linkedList.addFirst(10);
        linkedList.display();
        linkedList.addFirst(12);
        linkedList.display();
        linkedList.addLast(18);
        linkedList.display();
        linkedList.addLast(13);
        linkedList.display();
        System.out.println("Kth Node From Start "+linkedList.kthNodeFromStart(1));
        System.out.println("Kth Node From End "+linkedList.kthNodeFromEnd(1));
        linkedList.reverse();
        System.out.println("reverse");
        linkedList.display();
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.getMiddle());
        linkedList.addAt(14,3);

        linkedList.display();
        linkedList.removeFirst();
        linkedList.display();
        linkedList.removeLast();
        linkedList.display();
        linkedList.removeAt(1);
        linkedList.display();
        System.out.println(linkedList.getMiddle());
    }
}
