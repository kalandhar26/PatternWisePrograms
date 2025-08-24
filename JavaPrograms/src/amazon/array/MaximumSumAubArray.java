package amazon.array;

public class MaximumSumAubArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(maxSum(array));

    }

    public static  int maxSum(int[] array){
        int currentSum=0, maximumSum=0;
        for(int k : array){
           currentSum = Math.max(k, currentSum+k);
           maximumSum = Math.max(currentSum,maximumSum);
        }
        return  maximumSum;
    }
}
