package com.interview.ds.binarysearch;

/**
 * Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'.
 * Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'.
 */
public class FloorAndCeilOfNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 7, 8, 8, 10};
        int x = 5;
        System.out.println(floor(arr, x));
        System.out.println(ceil(arr, x));
    }

    private static int floor(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int floor = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]<=x){
                floor = arr[mid];
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return floor;
    }

    private static int ceil(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int ceil = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>=x){
                ceil = arr[mid];
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ceil;
    }
}
