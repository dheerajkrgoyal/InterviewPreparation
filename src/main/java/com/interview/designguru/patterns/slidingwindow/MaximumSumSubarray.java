package com.interview.designguru.patterns.slidingwindow;

/**
 * Given an array of positive numbers and a positive number 'k,' find the maximum sum of any
 * contiguous subarray of size 'k'.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * Example 2:
 *
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaximumSumSubarray {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 5, 1, 3, 2};
        System.out.println(findMaxSumSubArray(3, arr));
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        int left = 0;
        int right = 0;
        int sum = 0;
        while(right<arr.length){
            sum += arr[right];
            while(left<right && right-left+1 > k){
                sum -= arr[left];
                left++;
            }

            if(right-left+1 == k){
                maxSum = Math.max(sum, maxSum);
            }
            right++;
        }
        return maxSum;
    }
}
