package com.interview.designguru.patterns.warmup;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(validAnagram("silent", "listen"));
        System.out.println(validAnagram("rat", "ratc"));
    }

    private static boolean validAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> map= new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) +1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) -1);
        }

        for(Character c: map.keySet()){
            if(map.get(c) != 0){
                return false;
            }
        }
        return true;
    }
}
