package com.interview.ds.binarysearch;

/**
 * You are given an integer array bloomDay, an integer m and an integer k.
 *
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 *
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used
 * in exactly one bouquet.
 *
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden.
 * If it is impossible to make m bouquets return -1.
 */
public class MinimumDaysToMakeBouquets {
    public static void main(String[] args) {
        int[] bloomDays = new int[] {1,10,3,10, 2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDays, m, k));
        bloomDays = new int[]{7,7,7,7,12,7,7};
        System.out.println(minDays(bloomDays, 2, 3));
    }

    private static int minDays(int[] arr, int m, int k){
        int low = 1;
        int high = max(arr);
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(possible(mid, arr, m, k)){
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

    private static boolean possible(int minDays, int[] arr, int m, int k){
        int b = 0;
        int f = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]<=minDays){
                f++;
                if(f==k){
                    b++;
                    if(b==m){
                        return true;
                    }
                    f=0;
                }
            }
            else{
                f=0;
            }
        }
        return false;
    }
}
