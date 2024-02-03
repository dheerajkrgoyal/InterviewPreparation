package com.interview.ds.arrays;

import java.util.Arrays;

public class MoveZeroToEnd {
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,2,0,0,4,5,1};
        moveZero(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZero(int[] arr){
        int i = 0;
        for(int j = 0; j<arr.length; j++){
            if(arr[j] != 0){
                arr[i] = arr[j];
                i++;
            }
        }
        while(i<arr.length){
            arr[i] = 0;
            i++;
        }
    }
}
