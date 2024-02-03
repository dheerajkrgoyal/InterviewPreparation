package com.interview.ds.arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,2,2,3,3,3};
        int n = removeDuplicate(arr);

        for(int i = 0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static int removeDuplicate(int[] arr){
        int i = 0;
        for(int j = 1; j<arr.length; j++){
            if(arr[j] != arr[i]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }
}
