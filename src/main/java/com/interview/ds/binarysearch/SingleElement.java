package com.interview.ds.binarysearch;

/**
 * Given an array such that every element occurred twice except one. return the no. that appears only once;
 */
public class SingleElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,4,5,5};
        System.out.println(singleElement(arr));
    }

    /**
     * let us say we have array [1,1,2,2,4,5,5]
     * if we observe the index of the elements  before single element is [even, odd]
     * and after single element is [odd, even]. we will use this observation to discard the one half of
     * the array if we do not find single element in the mid. for the mid to be a single element index
     * before it and index after it should not be same;
     *
     * @param arr
     * @return
     */
    private static int singleElement(int[] arr){
        if(arr.length == 1){
            return arr[0];
        }

        if(arr[0] != arr[1]){
            return arr[0];
        }

        if(arr[arr.length-1]!=arr[arr.length-2]){
            return arr[arr.length-1];
        }

        int low = 1;
        int high = arr.length-2;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }
            else if((mid%2 == 1 && arr[mid -1] == arr[mid]) || (mid%2 == 0 && arr[mid+1] == arr[mid])){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}
