package amazon.string;

import java.util.ArrayDeque;

public class ValidParanthesis {
    public static void main(String[] args) {
        String input = "{[]}()";
        System.out.println(isValidString(input));
    }

    private static boolean isValidString(String input){
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(char c : input.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                   if(!stack.isEmpty() && (c=='}' && stack.peek()=='{' || c==']' && stack.peek()=='[' || c==')' && stack.peek()=='(')){
                       stack.pop();
                   }else{
                       return false;
                   }

            }
        }

        return stack.isEmpty();
    }

}
