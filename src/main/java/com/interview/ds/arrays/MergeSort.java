package com.interview.ds.arrays;

import java.util.Arrays;

/**
 * divide the array until single element is left
 * and then keep on merging in the sorted order
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,9,5,4,8,7,6};
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr){
        divide(arr, 0, arr.length-1);
    }

    private static void divide(int[] arr, int left, int right){
        if(left>=right) {
            return;
        }
        int mid = left + (right-left)/2;
        divide(arr, left, mid);
        divide(arr, mid+1, right);
        merge(arr, left, mid, right );
    }

    private static void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=right){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=right){
            temp[k++] = arr[j++];
        }

        for(int l = left; l<=right; l++){
            arr[l] = temp[l-left];
        }
    }
}
