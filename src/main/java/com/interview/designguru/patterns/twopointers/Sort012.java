package com.interview.designguru.patterns.twopointers;

import java.util.Arrays;

/**
 *
 Given an array containing 0s, 1s and 2s, sort the array in-place.
 You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to
 recreate the array.
 */
public class Sort012 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while(mid<high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
