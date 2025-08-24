package stack;

public class TestCustomStack {

    public static void main(String[] args) {
        CustomStack<Integer> integerList = new CustomStack<>();
        MyCustomStack<Integer> intList = new MyCustomStack<>();

        for(int i=0;i<10;i++){
            integerList.push(i);
            intList.push(i);
        }

        integerList.display();
        System.out.println(integerList.peek());
        System.out.println(integerList.pop());
        integerList.display();

        System.out.println("=============================");
        intList.display();
        System.out.println(intList.peek());
        System.out.println(intList.pop());
        intList.display();

    }
}
