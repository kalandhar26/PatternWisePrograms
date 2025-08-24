package arrays;

import java.util.Arrays;

public class MaxProductSubArray {

    public static void main(String[] args) {

        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArrayProduct(array));
        System.out.println(Arrays.toString(maxProductSubArray(array)));
    }

    public static int maxSubArrayProduct(int[] array) {
        if (array == null || array.length == 0) return 0;

        int maxProduct = array[0];
        int minProduct = array[0];
        int result = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < 0) {
                // Swap because multiplying by a negative flips min and max
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(array[i], maxProduct * array[i]);
            minProduct = Math.min(array[i], minProduct * array[i]);

            result = Math.max(result, maxProduct);
        }
        return result;
    }

    public static int[] maxProductSubArray(int[] array) {
        if (array == null || array.length == 0) return new int[0];

        int maxProduct = array[0];
        int minProduct = array[0];
        int result = array[0];

        int start = 0;       // Start of current max product
        int end = 0;         // End of final max product
        int tempStart = 0;   // Temp start index

        for (int i = 1; i < array.length; i++) {
            if (array[i] < 0) {
                // Swap values
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            if (array[i] > maxProduct * array[i]) {
                maxProduct = array[i];
                tempStart = i;
            } else {
                maxProduct = maxProduct * array[i];
            }

            minProduct = Math.min(array[i], minProduct * array[i]);

            if (maxProduct > result) {
                result = maxProduct;
                start = tempStart;
                end = i;
            }
        }

        // Extract subarray
        int[] resultArray = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            resultArray[i - start] = array[i];
        }
        return resultArray;
    }
}
