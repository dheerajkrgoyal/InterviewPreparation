package com.interview.designguru.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * You can assume that K is less than or equal to the length of the given string.
 *
 * Example 1:
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:
 *
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * Example 3:
 *
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class LongestSubstringWithKDistinctChar {

    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2));
    }

    public static int findLength(String str, int k) {
        int maxLength = 0;

        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(right < str.length()){
            char c = str.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(left<right && map.size() > k){
                char cl = str.charAt(left);
                map.put(cl, map.get(cl) - 1);
                if(map.get(cl) == 0){
                    map.remove(cl);
                }
                left++;
            }

            if(map.size() <= k){
                maxLength = Math.max(maxLength, right-left+1);
            }
            right++;
        }
        return maxLength;
    }
}
