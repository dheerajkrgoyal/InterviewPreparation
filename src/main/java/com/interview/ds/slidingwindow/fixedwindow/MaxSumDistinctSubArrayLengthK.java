package com.interview.ds.slidingwindow.fixedwindow;

import java.util.HashSet;
import java.util.Set;

public class MaxSumDistinctSubArrayLengthK {
    public static void main(String[] args) {
        int[] arr = new int[]{9,18,10,13,17,9,19,2,1,18};
        int k = 5;
        System.out.println(maxSubArray(arr, k));
    }

    private static long maxSubArray(int[] nums, int k){
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        while(right<nums.length){
            if(!set.contains(nums[right])){
                sum+=nums[right];
                set.add(nums[right]);
            }
            else{
                while(set.contains(nums[right])){
                    sum-=nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                continue;
            }

            while(right-left+1>k){
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            if(right-left+1==k){
                maxSum = Math.max(maxSum, sum);
            }
            right++;
        }

        return maxSum == Integer.MIN_VALUE? 0: maxSum;
    }
}
