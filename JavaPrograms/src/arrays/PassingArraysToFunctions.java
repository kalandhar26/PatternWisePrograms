package arrays;

import java.util.Arrays;

public class PassingArraysToFunctions {

    public static void main(String[] args) {
        int myMoney = 100;
        int[] friendsMoney = {100,200,300,400};

        doubleMoney(myMoney);
        doubleMoney(friendsMoney);

        System.out.println(myMoney);
        System.out.println(Arrays.toString(friendsMoney));
    }

    public static void doubleMoney(int myMoney){
        myMoney = 2 * myMoney;
    }

    public static void doubleMoney(int[] friendsMoney){
        for(int i=0;i<friendsMoney.length;i++){
            friendsMoney[i] = 2* friendsMoney[i];
        }
    }
}
