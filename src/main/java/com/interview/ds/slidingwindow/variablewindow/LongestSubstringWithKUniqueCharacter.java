package com.interview.ds.slidingwindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacter {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

        System.out.println(longestSubString(s, k));
    }

    private static int longestSubString(String s, int k){
        int maxLength = -1;
        Map<Character, Integer> map  = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right<s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) +1);
            while(map.size() > k){
                char c = s.charAt(left);
                map.put(c, map.get(c)-1);
                if(map.get(c)==0){
                    map.remove(c);
                }
                left++;
            }

            if(map.size() == k){
                maxLength = Math.max(maxLength, right-left+1);
            }
            right++;
        }

        return maxLength;
    }
}

