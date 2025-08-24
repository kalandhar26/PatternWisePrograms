package stack;

import java.util.Stack;

public class isValidParenthesisString {

    public static void main(String[] args) {

        String input = "[{()}]";

        System.out.println(isStringBalanced(input));
    }

    public static  boolean isStringBalanced(String input){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<input.length();i++){
            char character = input.charAt(i);

            if(character == '[' || character == '{' || character == '('){
                stack.push(character);
            }else{
                if (stack.isEmpty()) {
                    return false;
                }
                if(character == ']' && stack.peek().equals('[') || character == '}' && stack.peek().equals('{') || character == ')' && stack.peek().equals('(')){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
