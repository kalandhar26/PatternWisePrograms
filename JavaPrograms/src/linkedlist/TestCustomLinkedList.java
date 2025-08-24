package linkedlist;

import arraylist.CustomArrayList;
import common.Employee;

public class TestCustomLinkedList {

    public static void main(String[] args) {
        System.out.println("============ Integer List ============");

        CustomLinkedList<Integer> integerList = new CustomLinkedList<Integer>();
        for(int i=0;i<=10;i++){
            integerList.add(i);
        }
        integerList.display();
        System.out.println("Size: "+integerList.size());

        integerList.removeAt(5);
        integerList.display();
        integerList.addAt(5,235);
        integerList.display();
        System.out.println("Size: "+integerList.size());

        System.out.println(integerList.get(5));
        integerList.display();
        System.out.println("Middle Node : "+integerList.getMiddle());

        System.out.println("============ String List ============");

        CustomLinkedList<String> stringList = new CustomLinkedList<String>();
        for(int i=0;i<=10;i++){
            stringList.add("employee"+i);
        }
        stringList.display();
        System.out.println("Size: "+stringList.size());

        stringList.removeAt(5);
        stringList.display();
        System.out.println("Size: "+stringList.size());

        System.out.println(stringList.get(5));

        System.out.println("============ Employee List ============");

        CustomLinkedList<Employee> empList = new CustomLinkedList<Employee>();
        for(int i=0;i<=10;i++){
            Employee emp = new Employee(1+i,"emp"+i,18+i,"piler"+i);
            empList.add(emp);
        }
        empList.display();
        System.out.println("Size: "+empList.size());

        empList.removeAt(5);
        empList.display();
        System.out.println("Size: "+empList.size());

        System.out.println(empList.get(5));
    }
}
