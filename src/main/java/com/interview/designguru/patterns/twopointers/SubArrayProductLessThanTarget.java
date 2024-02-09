package com.interview.designguru.patterns.twopointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array with positive numbers and a positive target number, find all of its contiguous
 * subarrays whose product is less than the target number.
 *
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 *
 * Input: [8, 2, 6, 5], target=50
 * Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
 * Explanation: There are seven contiguous subarrays whose product is less than the target.
 */
public class SubArrayProductLessThanTarget {

    public static void main(String[] args) {
        System.out.println(subArray(new int[]{2, 5,3,10}, 30));
        System.out.println(subArray(new int[]{8,2,6,5}, 50));
    }

    private static List<List<Integer>> subArray(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int p = 1;
        while(right<arr.length){
            p *= arr[right];
            while(left<=right && p>=target){
                p /= arr[left];
                left++;
            }

            if(p<target){
                List<Integer> temp = new LinkedList<>();
                for(int i = right; i>=left; i--){
                    temp.add(0,arr[i]);
                    result.add(new ArrayList<>(temp));
                }
            }
            right++;
        }
        return result;
    }
}
