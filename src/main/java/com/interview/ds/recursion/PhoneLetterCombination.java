package com.interview.ds.recursion;

import java.util.*;

public class PhoneLetterCombination {

    public static void main(String[] args) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));

        String digits = "23";

        System.out.println(phoneCombination(digits, "", map));
    }

    private static List<String> phoneCombination(String digits, String ans, Map<Character, List<Character>> map){
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()){
            result.add(ans);
            return result;
        }

        char digit = digits.charAt(0);
        for(char ch: map.get(digit)){
            result.addAll(phoneCombination(digits.substring(1), ans+ch, map));
        }

        return result;
    }
}
