package amazon.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] array = {9, 7, 5, 2, 4, 1};
        System.out.println(Arrays.toString(twoSum(13, array)));
        System.out.println(Arrays.toString(twoSumm(13,array)));
        System.out.println(Arrays.toString(twoSumUsingMap(10,array)));
    }



    // Brute Force ( O(n^2))
    public static int[] twoSumm(int target, int[] array) {
        int n = array.length;

        for (int j : array) {
            for (int k : array) {
                if (target == j + k) {
                    return new int[]{j, k};
                }
            }
        }

        return new int[0];
    }

    // Sort + Two Pointers O(n log n)
    public static int[] twoSum(int target, int[] array) {
        int n = array.length;
        Arrays.sort(array);
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == target) {
                return new int[]{array[left], array[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0];
    }

    // Using HashMap O(n)
    public static int[] twoSumUsingMap(int target, int[] array){
        Map<Integer,Integer> map = new HashMap<>();

        for(int first : array){
            int second = target - first;
            if(map.containsKey(second)){
                return new int[]{first,second};
            }
            map.put(first,map.getOrDefault(first,1)+1);
        }
        return new int[0];
    }
}
