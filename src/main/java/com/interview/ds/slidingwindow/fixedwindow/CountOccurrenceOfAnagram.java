package com.interview.ds.slidingwindow.fixedwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrenceOfAnagram {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(search(txt, pat));
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
