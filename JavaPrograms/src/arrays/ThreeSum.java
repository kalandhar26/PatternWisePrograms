package arrays;

public class ThreeSum {

    public static void main(String[] args) {
        int[] array = {3,6,7,9,11,13,2,5};
        int[] output = findThreeSum(array,20);

        for(int x : output)
            System.out.println(x);

    }

    public static int[] findThreeSum(int[] array, int target){
        int n = array.length;

        for(int i=0;i<n;i++){

            if(i> 0 && array[i]==array[i-1]) continue;

         int left = i+1;
         int right = n-1;

         while(left<right){
             int sum = array[i]+array[left]+array[right];
             if(sum == target){
                 return new int[]{array[i], array[left], array[right]
                 };
             } else if (sum < target) {
                 left++;
             }else {
                 right--;
             }
         }
        }

        return new int[0];
    }
}
