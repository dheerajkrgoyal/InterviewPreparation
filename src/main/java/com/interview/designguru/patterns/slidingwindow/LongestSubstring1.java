package com.interview.designguru.patterns.slidingwindow;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.
 *
 * Example 1:
 *
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s
 * having length 6.
 * Example 2:
 *
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s
 * having length 9.
 */
public class LongestSubstring1 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        System.out.println(findLength(arr, 3));
    }

    public static int findLength(int[] arr, int k) {
        int maxLength = 0;

        int count = 0;
        int left = 0;
        int right = 0;

        while(right<arr.length){
            if(arr[right] == 0){
                count++;
            }

            while(left<right && count>k){
                if(arr[left] == 0){
                    count--;
                }
                left++;
            }

            if(count<=k){
                maxLength = Math.max(maxLength, right-left+1);
            }
            right++;
        }

        return maxLength;
    }
}
