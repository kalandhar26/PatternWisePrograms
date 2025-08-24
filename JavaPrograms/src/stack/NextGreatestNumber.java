package stack;

import java.util.Stack;

public class NextGreatestNumber {

    public static void main(String[] args) {
        int[] array = {8,2,3,6,1,4,8,9,1};
        int n = array.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= array[i]){
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(array[i]);
        }

        for(int x : result){
            System.out.println(x);
        }
    }
}
