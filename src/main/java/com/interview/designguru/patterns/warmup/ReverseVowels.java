package com.interview.designguru.patterns.warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases,
 * more than once.
 */
public class ReverseVowels {

    public static void main(String[] args) {
        String s = "DesignGUrus";
        System.out.println(reverseVowel(s));
    }

    private static String reverseVowel(String s){
        Set<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length-1;
        while(left<right){
            while(left<right && !vowels.contains(charArray[left])){
                left++;
            }

            while(left<right && !vowels.contains(charArray[right])){
                right--;
            }
            if(left<right){
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(charArray);
    }
}
