package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        int[] array = {1,2,9,8,6,7,5,3,4};
        int[] result = twoSum(array,8);

        displayArray(result);



    }

    public  static  int[] twoSum(int[] array, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< array.length;i++){
            int firstNumber = array[i];
            int secondNumber = target - firstNumber;
            if(map.containsKey(secondNumber)){
                return new int[] {firstNumber, secondNumber}; // Give values
            //    return  new int[]{i, map.get(secondNumber)}; // Give indexs

            }
            map.put(firstNumber,i);
        }

        return new int[0];
    }


    public static void displayArray(int[] array){
        System.out.print("[");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
            if(i<array.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");

    }
}
