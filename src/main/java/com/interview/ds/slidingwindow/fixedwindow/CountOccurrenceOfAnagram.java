package com.interview.ds.slidingwindow.fixedwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrenceOfAnagram {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(search(txt, pat));
        System.out.println(search2(txt, pat));
    }

    private static int search2(String txt, String pat){
        int left = 0;
        int right = 0;
        int res = 0;
        //create a map of pattern
        Map<Character, Integer> map = createDictionary(pat);
        //maintain count of unique chars
        int count = map.size();
        while(right<txt.length()){
            char c = txt.charAt(right);
            //check if char is in map if yes decrease the count, when no of char become zero decrease count
            if(map.containsKey(c)){
                map.put(c, map.get(c) -1);
                if(map.get(c) == 0){
                    map.remove(c);
                    count--;
                }
            }
            //if window size is greater than required which is pat.length()
            //decrease the window size by removing char from left
            //while removing char from check if it belongs to pattern or not if it does add back in
            // pattern map
            while(right-left+1>pat.length()){
                char cl = txt.charAt(left);
                if(pat.indexOf(cl) != -1){
                    map.put(cl, map.getOrDefault(cl, 0) +1);
                    if(map.get(cl) == 1){
                        count++;
                    }
                }
                left++;
            }

            //if window size is exactly the pattern length(required) and count == 0(meaning all characters of pattern are there)
            if(right-left+1 == pat.length() && count  == 0){
                res++;
            }
            right++;
        }
        return res;
    }

    private static int search(String txt, String pat){
        int left = 0;
        int right = 0;
        int res = 0;
        Map<Character, Integer> mainMap = createDictionary(pat);
        Map<Character, Integer> map  = new HashMap<>();
        while(right<txt.length()){
            char c = txt.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);

            while(right-left+1>pat.length()){
                map.put(txt.charAt(left), map.get(txt.charAt(left))-1);
                if(map.get(txt.charAt(left)) == 0){
                    map.remove(txt.charAt(left));
                }
                left++;
            }

            if(right-left+1 == pat.length()){
                //check anagram
                if(checkAnagram(mainMap, map)) {
                    res++;
                }
            }
            right++;
        }

        return res;
    }

    private static Map<Character, Integer> createDictionary(String pat){
        Map<Character, Integer> map = new HashMap<>();
        for(char p: pat.toCharArray()){
            map.put(p, map.getOrDefault(p, 0) +1);
        }
        return map;
    }

    private static boolean checkAnagram(Map<Character, Integer> mainMap, Map<Character, Integer> map){
        for(Character key: map.keySet()){
            if(!mainMap.containsKey(key) || !mainMap.get(key).equals(map.get(key))){
                return false;
            }
        }
        return true;
    }
}
