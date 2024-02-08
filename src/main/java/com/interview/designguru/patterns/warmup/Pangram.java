package com.interview.designguru.patterns.warmup;

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing English letters (lower or upper-case), return true if sentence is
 * a pangram, or false otherwise.
 *
 * Note: The given sentence might contain other characters like digits or spaces, your solution should
 * handle these too.
 */
public class Pangram {
    public static void main(String[] args) {
        String s = "TheQuickBrownFoxJumpsOverTheLazyDog";
        System.out.println(checkPangram(s));
        s = "This is not pangram";
        System.out.println(checkPangram(s));
    }

    private static boolean checkPangram(String s){
        int[] map = new int[26];
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                map[Character.toUpperCase(c)-'A'] = 1;
            }
        }

        for(int i = 0; i<map.length; i++){
            if(map[i] == 0){
                return false;
            }
        }

        return true;
    }
}
