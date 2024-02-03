package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(arr, target, 0, 0, new ArrayList<>()));
        arr = new int[]{2,3,5};
        target = 8;
        System.out.println(combinationSum(arr, target, 0, 0, new ArrayList<>()));
    }

    private static List<List<Integer>> combinationSum(int[] arr, int target, int index, int sum, List<Integer> ans){
        List<List<Integer>> result = new ArrayList<>();
        if(index==arr.length){
            if(target == sum){
                result.add(new ArrayList<>(ans));
            }
            return result;
        }

        result.addAll(combinationSum(arr, target, index+1, sum, ans));//don't pick
        if(sum+arr[index]<=target) {
            ans.add(arr[index]);
            result.addAll(combinationSum(arr, target, index, sum + arr[index], ans));
            ans.remove(ans.size()-1);
        }
        return result;
    }
}
