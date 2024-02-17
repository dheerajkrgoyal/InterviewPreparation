package com.interview.ds.slidingwindow.variablewindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabcbb"));
    }

    private static int longestSubstring(String s){
        int left = 0;
        int right = 0;
        int res = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
            }
            else{
                while(left<right && set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }

            res = Math.max(res, right-left+1);
            right++;
        }

        return res;
    }
}
