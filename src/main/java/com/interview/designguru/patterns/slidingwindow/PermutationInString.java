package com.interview.designguru.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Or Anagram in string.
 * the character frequency of pattern should match the sliding windows
 */
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(findPermutation("aaacb", "abc"));
    }

    public static boolean findPermutation(String str, String pattern) {
        if(pattern.length()>str.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c: pattern.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        int left = 0;
        int right = 0;
        int count = 0;
        while(right<str.length()){
            char c = str.charAt(right);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0){
                    count++;
                }
            }

            if(right-left+1>pattern.length()){
                char cr = str.charAt(left);
                if(map.containsKey(cr)){
                    if(map.get(cr) == 0){
                        count--;
                    }
                    map.put(cr, map.getOrDefault(cr, 0) +1);
                }
                left++;
            }

            if(right-left+1 == pattern.length() && count == map.size()){
                return true;
            }
            right++;
        }
        return false;
    }
}
