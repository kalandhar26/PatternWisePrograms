package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, return true if any value appears at
 * least twice in the array, and return false if every element is
 * distinct.
 **/
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] array = {1,3,4,5,9,9,8,7,6};

        System.out.println(containsDuplicate(array));

    }

    public static  boolean containsDuplicate(int[] array){
        Map<Integer, Integer> map = new HashMap<>();
        boolean duplicateExists = false;
        for(int i=0;i< array.length;i++){
            if(map.containsKey(array[i])){
                duplicateExists = true;
            }
            map.put(array[i],i);
        }

        return duplicateExists;
    }
}
