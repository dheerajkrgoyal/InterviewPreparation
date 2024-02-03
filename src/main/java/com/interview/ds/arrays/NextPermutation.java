package com.interview.ds.arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,4,3,0,0};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void nextPermutation(int[] arr){
        int ind = -1;
        for(int i = arr.length-2; i>=0; i--){
            if(arr[i]<arr[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            reverse(arr, 0, arr.length-1);
        }
        else{
            for(int i = arr.length-1; i>ind; i--){
                if(arr[i]>arr[ind]){
                    int temp = arr[ind];
                    arr[ind] = arr[i];
                    arr[i] = temp;
                    break;
                }
            }
            reverse(arr, ind+1, arr.length-1);
        }
    }

    private static void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
