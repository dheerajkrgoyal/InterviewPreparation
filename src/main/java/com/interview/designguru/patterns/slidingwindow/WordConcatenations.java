package com.interview.designguru.patterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenations {
    public static void main(String[] args) {
        System.out.println(findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
    }

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();

        Map<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int matched = 0;
        int totalLength = words.length * words[0].length();
        int wordLength = words[0].length();

        while(right<str.length()){
            String w = str.substring(right, right+wordLength);
            if(map.containsKey(w)){
                map.put(w, map.get(w) - 1);
                if(map.get(w) == 0){
                    matched++;
                }
            }

            if(right-left+1>totalLength){
                String wl = str.substring(left, left+wordLength);
                if(map.containsKey(wl)){
                    if(map.get(wl) == 0){
                        matched--;
                    }
                    map.put(wl, map.getOrDefault(wl, 0) + 1);
                }
                left+=wordLength;
            }

            if(matched == map.size()){
                System.out.println("str: " + str.substring(left, right+1));
                System.out.println("matched: " + matched);
                System.out.println("map: " + map);

                resultIndices.add(left);
            }
            right+=wordLength;
        }

        return resultIndices;
    }
}
