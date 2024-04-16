package com.interview.designguru.patterns.slidingwindow;

/**
 * Given an array of positive integers and a number ‘S,’ find the length of the smallest contiguous
 * subarray whose sum is greater than or equal to 'S'. Return 0 if no such subarray exists.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 * Example 2:
 *
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 * Example 3:
 *
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
 */
public class SmallestSubarrayWithGreaterSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 2, 3, 2};
        System.out.println(findMinSubArray(7, arr));
    }

    public static int findMinSubArray(int S, int[] arr) {
        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while(right<arr.length){
            sum += arr[right];

            if(sum>=S){
                minLength = Math.min(minLength, right-left+1);
            }

            while(left<right && sum>=S){
                sum -= arr[left];
                left++;
                if(sum>=S){
                    minLength = Math.min(minLength, right-left+1);
                }
            }

            right++;
        }
        return minLength == Integer.MAX_VALUE? 0 : minLength;
    }
}
