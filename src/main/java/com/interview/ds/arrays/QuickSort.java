package com.interview.ds.arrays;

import java.util.Arrays;

/**
 * pick the element as pivot (pivot can be anything)
 * place the pivot element in its right place
 * smaller element than pivot will be on the left and larger element will be on right
 * repeat the steps for each partition on left and right
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{4,6,2,5,7,9,1,3};
//        System.out.println("Unsorted array: " + Arrays.toString(arr));
//        quicksort(arr);
//        System.out.println("Sorted array: " + Arrays.toString(arr));

        int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        quicksort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    private static void quicksort(int[] arr){
        divide(arr, 0, arr.length-1);
    }

    private static void divide(int[] arr, int low, int high){
        if(low<high){
            int pIndex = pivot(arr, low, high);
            divide(arr, low, pIndex -1);
            divide(arr, pIndex+1, high);
        }
    }

    private static int pivot(int[] arr, int low, int high){
        //select the starting index as pivot
        int pivot = arr[low];
        //take left and right pointer
        int i = low;
        int j = high;
        while(i<j){
            //find element which is greater than pivot element
            while(arr[i]<=pivot && i<high){
                i++;
            }
            //find element which is lesser than pivot element
            while(arr[j]>pivot && j>low){
                j--;
            }
            //swap the two element, idea is all element smaller than pivot should be on one side
            //and all element greater than pivot on the other side
            if(i<j){
                swap(arr, i, j);
            }
        }
        //swap
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
