package amazon.string;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("eat","ate"));
        System.out.println(isAnagram2("earth","hearts"));
    }

    private static boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length())
            return false;

       int[] count = new int[26];

       for(int i=0;i<str1.length();i++){
           int value1 = str1.charAt(i) - 'a';
           int value2 = str2.charAt(i) - 'a';
           count[value1]++;
           count[value2]--;
       }

       for(int value : count){
           if(value != 0){
               return false;
           }
       }
       return true;
    }

    private static boolean isAnagram2(String str1, String str2){
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return  Arrays.equals(array1,array2);

    }


}
