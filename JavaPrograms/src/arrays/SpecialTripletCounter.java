package arrays;

/**
 * Problem 2: Count Special Triplets
 * ----------------------------------
 * Given an integer array, slide a window of size 3 and count how many such triplets
 * satisfy the condition: first + third = second
 * <p>
 * Method: countSpecialTriplets()
 * <p>
 * Example Input:  {1, 2, 1, 4, 1, 2, 1, 2, 4, 2}
 * Example Output: 3
 * <p>
 * Explanation:
 * Valid triplets where a + c == b:
 * [1, 2, 1] → 1 + 1 = 2 ✔
 * [1, 2, 1] → 1 + 1 = 2 ✔
 * [2, 4, 2] → 2 + 2 = 4 ✔
 **/

public class SpecialTripletCounter {

    public static void main(String[] args) {

        int[] tripletArray = {1, 2, 1, 4, 1, 2, 1, 2, 4, 2};
        int count = countSpecialTriplets(tripletArray);
        System.out.println("Count of Special Triplets: " + count); // Expected: 3
    }

    /**
     * Counts triplets (a, b, c) in sliding windows of size 3 where a + c == b
     */
    public static int countSpecialTriplets(int[] array) {
        int count = 0;

        for (int i = 0; i <= array.length - 3; i++) {
            int first = array[i];
            int second = array[i + 1];
            int third = array[i + 2];

            if (first + third == second) {
                count++;
            }
        }

        return count;
    }
}
