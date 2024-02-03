package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

 */
public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 2, 7,6,1,5};
        int target = 8;
        Arrays.sort(arr);
        System.out.println(combinationSum2(arr, target, 0, 0, new ArrayList<>()));
    }

    private static List<List<Integer>> combinationSum2(int[] arr, int target, int i, int sum, List<Integer> ans){
        List<List<Integer>> result = new ArrayList<>();
        if(i == arr.length){
            if(sum == target){
                result.add(new ArrayList<>(ans));
            }
            return result;
        }

        //pick it and move forward(since can choose only once)
        if(sum+arr[i] <= target){
            ans.add(arr[i]);
            result.addAll(combinationSum2(arr, target, i+1, sum+arr[i], ans));
            ans.remove(ans.size()-1);
        }

        //skipping it, since may contain duplicate so skipping all duplicates
        while (i+1<arr.length && arr[i] == arr[i+1]){
            i++;
        }
        result.addAll(combinationSum2(arr, target, i+1, sum, ans));
        return result;
    }
}
