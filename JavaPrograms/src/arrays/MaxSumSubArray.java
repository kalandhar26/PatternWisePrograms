package arrays;

import java.util.Arrays;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubArraySum(array));
        System.out.println(Arrays.toString(maximumSumSubArray(array)));
    }


    public static  int maximumSubArraySum(int[] array){
        if (array == null || array.length == 0) return 0;
        int currentSum = array[0];
        int maximumSum = array[0];

        for(int i=1;i<array.length;i++){
            currentSum = Math.max(currentSum+array[i], array[i]);
            maximumSum = Math.max(maximumSum, currentSum);
        }

        return maximumSum;
    }

    public static int[] maximumSumSubArray(int[] array){

        if (array == null || array.length == 0) return new int[0];

        int startIndex =0, endIndex=0,tempStartIndex=0;
        int currentSum=array[0], maximumSum=array[0];

        for(int i =0;i<array.length;i++){

            if(array[i] > currentSum + array[i]){
                currentSum  = array[i];
                tempStartIndex = i;
            }else {
                currentSum += array[i];
            }

            if(currentSum > maximumSum){
                maximumSum = currentSum;
                startIndex = tempStartIndex;
                endIndex =  i;
            }
        }

        int[] result = new int[endIndex-startIndex+1];
        for(int i = startIndex; i<= endIndex; i++){
            result[i-startIndex] = array[i];
        }

        return result;
    }
}
