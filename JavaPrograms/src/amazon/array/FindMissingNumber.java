package amazon.array;

public class FindMissingNumber {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,8,9};
        System.out.println(findMissingNumber(array));
    }

    public static int findMissingNumber(int[] array){
        int n = array.length;
        int expectedSum = n*(n+1)/2;
        int actualSum =0;
        for(int k : array)
            actualSum += k;

        return expectedSum-actualSum;
    }
}
