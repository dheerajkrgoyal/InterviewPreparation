package com.interview.designguru.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters
 * with any letter, find the length of the longest substring having the same letters after replacement.
 *
 * Example 1:
 * Input: str="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 *
 * Example 2:
 * Input: str="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 *
 * Example 3:
 * Input: str="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class LongestSubstringWithSameLetterAfterReplacement {

    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));
        System.out.println(findLength("abbcb", 1));
        System.out.println(findLength("abccde", 1));
    }

    private static int findLength(String str, int k){

        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        int maxLength = Integer.MIN_VALUE;

        while(right<str.length()){
            char c = str.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));

            while(right-left+1-maxFreq > k){
                char cl = str.charAt(left);
                map.put(cl, map.get(cl) - 1);
                if(map.get(cl) == 0){
                    map.remove(cl);
                }
                left++;
            }

            if(right - left + 1-maxFreq <=k){
                maxLength = Math.max(maxLength, right-left +1);
            }

            right++;
        }
        return maxLength;
    }
}
