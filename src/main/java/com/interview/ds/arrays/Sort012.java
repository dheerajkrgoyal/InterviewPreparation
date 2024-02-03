package com.interview.ds.arrays;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,0,1,2,1,2,0,0,0,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{0,1,2,0,1,2,1,2,0,0,0,1};
        sortOptimal(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr){
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 0){
                count0++;
            }
            else if(arr[i] ==1){
                count1++;
            }
            else{
                count2++;
            }
        }
        for(int i = 0; i<count0;i++){
            arr[i] = 0;
        }
        for(int i = count0; i< count0+count1;i++){
            arr[i] = 1;
        }
        for(int i= count0+count1; i< count0+count1+count2; i++){
            arr[i] = 2;
        }
    }

    //use three pointers low, mid, high
    //everything between 0 to low-1 is 0
    //everything between low to mid-1 is 1
    //everything between mid to high is unsorted array
    //everything between high+1 to arr.length-1 is 2;
    private static void sortOptimal(int[] arr){
        int mid = 0;
        int high = arr.length-1;
        int low = 0;
        while(mid<=high){
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
