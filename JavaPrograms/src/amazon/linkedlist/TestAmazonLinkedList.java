package amazon.linkedlist;

public class TestAmazonLinkedList {

    public static void main(String[] args) {
        AmazonLinkedList linkedList = new AmazonLinkedList();

        for(int i=0;i<10;i++){
            linkedList.add(i);
        }

        linkedList.display();
        linkedList.reverse();
        linkedList.display();
        linkedList.reverse();
        linkedList.display();
        linkedList.reverseRecur();
        linkedList.display();
        System.out.println(linkedList.getMiddle());
        linkedList.reverseIter();
        linkedList.display();
        System.out.println(linkedList.getMiddle());
        System.out.println(linkedList.hasCycle());
    }
}
