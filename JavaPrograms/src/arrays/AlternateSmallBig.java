package arrays;

import java.util.Arrays;

/**
 * Problem 1: Rearrange Array in Alternate Min-Max Order
 * ------------------------------------------------------
 * Given an integer array, sort it and rearrange its elements such that the result alternates
 * between the smallest and largest remaining elements.
 * <p>
 * Example Input:  {2, 3, 4, 5, 1, 6, 7, 9}
 * Example Output: {1, 9, 2, 7, 3, 6, 4, 5}
 *
 **/

public class AlternateSmallBig {

    public static void main(String[] args) {
        int[] inputArray = {2, 3, 4, 5, 1, 6, 7, 9};
        int[] rearrangedArray = rearrangeMinMaxAlternate(inputArray);
        System.out.println("Rearranged Min-Max Alternate: " + Arrays.toString(rearrangedArray));
    }

    /**
     * Rearranges the array in an alternating order of min, max, min, max...
     */
    public static int[] rearrangeMinMaxAlternate(int[] array) {
        int n = array.length;
        int[] result = new int[n];
        Arrays.sort(array);

        int left = 0;           // Start of sorted array
        int right = n - 1;      // End of sorted array
        boolean takeMin = true;

        for (int i = 0; i < n; i++) {
            if (takeMin) {
                result[i] = array[left++];
            } else {
                result[i] = array[right--];
            }
            takeMin = !takeMin; // Alternate between min and max
        }

        return result;
    }

}
