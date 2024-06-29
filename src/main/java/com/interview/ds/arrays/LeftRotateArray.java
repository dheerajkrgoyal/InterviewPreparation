package com.interview.ds.arrays;

import java.util.Arrays;

public class LeftRotateArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        leftRotateOnePlace(arr);
        System.out.println(Arrays.toString(arr));
        int n = 2;
        leftRotateNPlace1(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    private static void leftRotateOnePlace(int[] arr) {
        int temp = arr[0];
        for(int i = 1; i<arr.length;i++){
            arr[i-1] = arr[i];
        }

        arr[arr.length-1] = temp;
    }


    //similar as one place instead of single variable we use array to hold the n elements
    @SuppressWarnings("unused")
    private static void leftRotateNPlace(int[] arr, int n){
        n = n%arr.length;
        int[] temp = new int[n];
        for(int i = 0; i<n; i++){
            temp[i] = arr[i];
        }

        for(int i = n; i<arr.length; i++){
            arr[i-n] = arr[i];
        }

        for(int i = arr.length-n; i<arr.length; i++){
            arr[i] = temp[i-(arr.length-n)];
        }
    }


    //can we do it without using extra space
    //reverse the array arr[0] till n-1, reverse the array n till arr.length-1, then reverse the whole array
    private static void leftRotateNPlace1(int[] arr, int n){
        n = n % arr.length;
        reverseArray(arr, 0, n-1);
        reverseArray(arr, n, arr.length-1);
        reverseArray(arr, 0, arr.length-1);
    }

    private static void reverseArray(int [] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end-- ;
        }
    }
}
