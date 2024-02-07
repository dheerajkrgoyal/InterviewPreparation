package com.interview.ds.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,1,-1,-1,0};
        int k = 0;
        System.out.println(longestSubArray(arr, k));

        System.out.println("count: " + countsubArray(arr, k));
        arr = new int[]{1,2,3,1,1,1,1,4,2,3};
        k = 3;
        System.out.println(slidingWindowApproach(arr, k));

    }

    private static int countsubArray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                count+= map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    //will work if arr has all negative, positive and zero
    //for each element we find sum and first check if sum == k then length is till present index or
    // check in map whether we have sum-k somewhere before that or not
    //if we do that means we will have sum-(sum-k) = k somewhere including the present index.
    //we hold the sum-k location in the map and subtract present location to that location to find the length
    //check if that length is max;
    private static int longestSubArray(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            sum+=arr[i];
            if(sum == k){
                maxLength = Math.max(maxLength, i+1);
            }
            else{
                int rem = sum-k;
                if(map.containsKey(rem)){
                    maxLength = Math.max(maxLength, i-map.get(rem));
                }
            }

            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        return maxLength;
    }


    //slidingWindowApproach only work if arr has positive and zero
    private static int slidingWindowApproach(int[] arr, int k){
        int left = 0;
        int right = 0;
        long sum = 0;
        int maxLength = Integer.MIN_VALUE;
        while(right < arr.length){
            sum+=arr[right];
            while(left <= right && sum>k) {
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }
}
