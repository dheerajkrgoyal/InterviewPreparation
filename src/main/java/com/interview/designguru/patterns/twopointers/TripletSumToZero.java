package com.interview.designguru.patterns.twopointers;

import java.util.*;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]
 * Explanation: There are four unique triplets whose sum is equal to zero.'
 *
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 */
public class TripletSumToZero {

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-5,2,-1,-2,3}));
    }

    private static List<List<Integer>> searchTriplet(int[] arr){
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(arr);
        for(int i = 0; i<arr.length; i++){
            if(i>0 &&  arr[i-1] == arr[i]){
                continue;
            }
            int left = i+1;
            int right = arr.length-1;
            while(left<right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0){
                    triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    while(left<right && arr[left-1] == arr[left]){
                        left++;
                    }
                    while(left<right && arr[right] == arr[right+1]){
                        right--;
                    }
                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return triplets;
    }
}
