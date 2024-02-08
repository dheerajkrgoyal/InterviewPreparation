package com.interview.designguru.patterns.warmup;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
 * removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal, Panama!";
        System.out.println(checkPalindrome(s));
        System.out.println(checkPalindrome("race a car"));
    }

    private static boolean checkPalindrome(String s){
        s = cleanString(s);
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private static String cleanString(String s){
        StringBuilder sb = new StringBuilder(s.length());
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c) || Character.isDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
