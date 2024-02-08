package com.interview.ds.binarysearch;

/**
 * Given an integer array ‘A’ of size ‘N’ and an integer ‘K’.
 * Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is
 * minimized. Your task is to return the minimized largest sum of the split.
 * A subarray is a contiguous part of the array.
 * Return the largest sum which has to minimum.
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 3;
        System.out.println(splitArray(arr, k));
    }

    private static int splitArray(int[] arr, int k){
        int low = max(arr);
        int high = sum(arr);
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(possible(mid, arr, k)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private static int sum(int[] arr){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }

    private static boolean possible(int maxSum, int[] arr, int k){
        int count = 1;
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            if(sum+arr[i]<=maxSum){
                sum+=arr[i];
            }
            else{
                sum = arr[i];
                count++;
                if(count>k){
                    return false;
                }
            }
        }
        return count<=k;
    }
}
