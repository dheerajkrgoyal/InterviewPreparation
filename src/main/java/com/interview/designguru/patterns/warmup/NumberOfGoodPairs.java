package com.interview.designguru.patterns.warmup;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums, return the number of good pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs, here are the indices: (0,3), (0,4), (3,4), (2,5).
 *
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array is a 'good pair'.
 *
 * Input: words = nums = [1,2,3]
 * Output: 0
 * Explanation: No number is repeating.
 */
public class NumberOfGoodPairs {
    public static void main(String[] args) {
        System.out.println(goodPairsCount(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(goodPairsCount(new int[]{1, 1, 1, 1}));
        System.out.println(goodPairsCount(new int[]{1,2,3}));
    }

    private static int goodPairsCount(int[] arr){
        int goodPairCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            // increment the count of 'n' in the map
            // every new occurrence of a number can be paired with every previous occurrence
            // so if a number has already appeared 'p' times, we will have 'p-1' new pairs
            goodPairCount += map.get(arr[i]) -1;
;        }

        return goodPairCount;
    }
}
