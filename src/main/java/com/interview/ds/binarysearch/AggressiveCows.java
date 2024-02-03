package com.interview.ds.binarysearch;

import java.util.Arrays;

/**
 * since stall coordinates are given
 * we can find the minimum distance between the stall coordinates
 * and max distance between the coordinates. once we have min and max, we use binary search to play around with di
 * fferent values to see if we can place all cows at that distance or not;
 */

public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = new int[]{0,3,4,7,10,9};
        int cows = 4;
        System.out.println(aggressiveCows(stalls, cows));
    }

    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int low = minDistance(stalls);
        int high = stalls[stalls.length-1] - stalls[0];
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(possible(mid, stalls, k)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return ans;
    }

    private static int minDistance(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<arr.length; i++){
            min = Math.min(min, arr[i] - arr[i-1]);
        }
        return min;
    }

    private static boolean possible(int minDistance, int[] stalls, int cows){
        int countCow= 1;
        int lastCow = stalls[0];
        for(int i = 1; i<stalls.length; i++){
            if(stalls[i]-lastCow>=minDistance){
                countCow++;
                lastCow = stalls[i];
                if(countCow == cows){
                    return true;
                }
            }
        }
        return false;
    }
}
