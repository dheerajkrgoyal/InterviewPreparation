package com.interview.ds.slidingwindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring
 * of s such that every character in t (including duplicates) is included in the window. If there
 * is no such substring, return the empty string "".
 */

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimum(s, t));
    }

    private static String minimum(String s, String t){
        if(t.length()>s.length()){
            return "";
        }

        int min = Integer.MAX_VALUE;
        String ans = s;
        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();

        while(right<s.length()){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0){
                    count--;
                }
            }


            while(count == 0){
                if(right-left+1<min){
                    min = right-left+1;
                    ans = s.substring(left, right+1);
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left)) +1);
                    if(map.get(s.charAt(left)) > 0){
                        count++;
                    }
                }
                left++;
            }

            right++;
        }
        return min == Integer.MAX_VALUE? "":ans;
    }
}
