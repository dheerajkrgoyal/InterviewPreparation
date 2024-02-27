package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.List;
/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible
palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]
 */

public class StringPalindromePartition {
    public static void main(String[] args) {
        String s = "aabc";
        System.out.println(partition(s, new ArrayList<>()));
    }

    private static List<List<String>> partition(String s, List<String> ans){
        List<List<String>> result = new ArrayList<>();
        if(s.isEmpty()){
            result.add(new ArrayList<>(ans));
            return result;
        }

        for(int i = 0; i<s.length(); i++){
            if(isPalindrome(s.substring(0, i+1))){
                ans.add(s.substring(0, i+1));
                result.addAll(partition(s.substring(i+1), ans));
                ans.remove(ans.size()-1);
            }
        }

        return result;
    }

    private static boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        return s.contentEquals(sb.reverse());
    }
}
