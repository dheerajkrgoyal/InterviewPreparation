package com.interview.ds.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr  = new int[]{2,4,5,7,9,11,15};
        System.out.println(binarySearch(arr, 11, 0, arr.length));
    }

    private static int binarySearch(int[] arr, int target, int s, int e){
        if(s>e){
            return -1;
        }

        int m = s + (e-s)/2;

        if(arr[m] == target){
            return m;
        }
        else if(arr[m] < target){
            return binarySearch(arr, target, m+1, e);
        }
        else{
            return binarySearch(arr, target, s, m-1);
        }

    }
}
