package amazon.array;

import java.util.Arrays;

public class RotateArrayByK {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        rotateArrayByKSpacesRight(array, 2);
        rotateArrayByKSpacesLeft(array, 2);

    }

    public static void rotateArrayByKSpacesRight(int[] array, int k) {
        int n = array.length;
        rotateArray(array, 0, n - 1);
        rotateArray(array, 0, k - 1);
        rotateArray(array, k, n - 1);
        System.out.println(Arrays.toString(array));

    }

    public static void rotateArrayByKSpacesLeft(int[] array, int k) {
        int n = array.length;
        rotateArray(array, 0, k - 1);
        rotateArray(array, k, n - 1);
        rotateArray(array, 0, n - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void rotateArray(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }
}
