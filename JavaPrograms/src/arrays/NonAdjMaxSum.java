package arrays;

public class NonAdjMaxSum {
    public static void main(String[] args) {
        int[] array = {6,7,3,4,9,5};
        System.out.println(nonAdjMaxSum(array));
    }

    public static int nonAdjMaxSum(int[] array){
        int n = array.length;

        if(n==0)
            return 0;
        if(n==1)
            return array[0];

        int prev1 = Math.max(array[0], array[1]);
        int prev2 = array[0];

        for(int i=2;i<n;i++){
            int current = Math.max(prev2, prev1+array[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
