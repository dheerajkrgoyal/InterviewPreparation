package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 */
public class Combination {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combination(n, k));
    }

    private static List<List<Integer>> combination(int n, int k){
        List<List<Integer>> result = new ArrayList<>();
        comb(1, n, k, new ArrayList<>(), result);
        return result;
    }

    //tail-recursion
    private static void comb(int i, int n, int k, List<Integer> ans, List<List<Integer>> result){
        if(k==0){
            result.add(new ArrayList<>(ans));
            return;
        }

        if(i>n){
            return;
        }

        //add it
        ans.add(i);
        comb(i+1, n, k-1, ans, result);
        ans.remove(ans.size()-1);


        //skip it
        comb(i+1, n, k, ans, result);


    }
}
