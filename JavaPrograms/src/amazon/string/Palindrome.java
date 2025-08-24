package amazon.string;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcba"));
    }

    public static boolean isPalindrome(String input){
        int start=0;
        int end = input.length()-1;

        while(start<end){
            if(input.charAt(start) != input.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
