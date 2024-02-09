package com.interview.designguru.patterns.twopointers;

import java.util.Arrays;

/**
 * Given an array of numbers sorted in ascending order and a target sum,
 * find a pair in the array whose sum is equal to the given target.
 *
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they
 * add up to the given target. If no such pair exists return [-1, -1].
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 *
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class PairWithTargetSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pair(new int[]{1,2,3,4,6}, 6)));
        System.out.println(Arrays.toString(pair(new int[]{2,5,9,11}, 11)));
    }

    private static int[] pair(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return new int[]{left, right};
            }
            else if(sum<target){
                left++;
            }
            else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}
