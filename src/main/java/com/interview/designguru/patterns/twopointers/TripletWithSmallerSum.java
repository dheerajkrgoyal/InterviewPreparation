package com.interview.designguru.patterns.twopointers;

import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that
 * arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 *
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 *
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target:
 * [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
public class TripletWithSmallerSum {

    public static void main(String[] args) {
        System.out.println(countTriplet(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(countTriplet(new int[]{-1, 4, 2, 1, 3}, 5));
    }

    private static int countTriplet(int[] arr, int targetSum){
        int count  = 0;
        Arrays.sort(arr);
        for(int i = 0; i<arr.length; i++){
            int left = i+1;
            int right = arr.length-1;
            while(left<right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum<targetSum){
                    // found the triplet
                    // since arr[right] >= arr[left], therefore, we can replace arr[right] by any
                    // number between left and right to get a sum less than the target sum
                    count+=right-left;
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return count;
    }
}
