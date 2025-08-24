package arrays;

public class MinimumAdjacentDifferenceFinder {

    public static void main(String[] args) {
        int[] inputArray = {8, -8, 9, -9, 10, -11, 12};
        int minimumDifference = findMinimumAdjacentDifference(inputArray);
        System.out.println("Minimum difference between adjacent elements: " + minimumDifference);
    }

    /**
     * Finds the minimum difference between any two adjacent elements in the array.
     */
    public static int findMinimumAdjacentDifference(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int minimumDifference = Integer.MAX_VALUE;

        for (int i = 1; i < array.length; i++) {
            int currentDifference = Math.abs(array[i] - array[i - 1]);
            minimumDifference = Math.min(minimumDifference, currentDifference);
        }

        return minimumDifference;
    }
}
