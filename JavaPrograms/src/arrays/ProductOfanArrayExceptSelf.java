package arrays;

import java.util.Arrays;

public class ProductOfanArrayExceptSelf {

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(array)));

    }

    public static int[] productExceptSelf(int[] array){
        int n = array.length;
        int leftProduct=1;
        int rightProduct=1;
        int[] result = new int[n];

        Arrays.fill(result,1);

        for(int i=0;i<n;i++){
            result[i] *= leftProduct;
            leftProduct *= array[i];
        }

        for(int i=n-1;i>=0;i--){
            result[i] *= rightProduct;
            rightProduct *= array[i];
        }

        return result;
    }
}
