package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(permutation(str, ""));

        System.out.println(permutation2(str, new boolean[str.length()], ""));

        System.out.println(permutation3(str, 0));
    }

    //1st approach pick 1st character of given string and place it in all position of ans string
    private static List<String> permutation(String str, String ans){
        List<String> result = new ArrayList<>();
        if(str.isEmpty()){
            result.add(ans);
            return result;
        }

        char ch = str.charAt(0);
        for(int i = 0; i<=ans.length(); i++){
            String s = ans.substring(0,i) + ch + ans.substring(i);
            result.addAll(permutation(str.substring(1), s));
        }

        return result;
    }

    //2nd approach pick each char of a given string and place it in 1st position and generate all ans string
    private static List<String> permutation2(String str, boolean[] freq, String ans){
        List<String> result = new ArrayList<>();
        if(ans.length() == str.length()){
            result.add(ans);
            return result;
        }

        for(int i = 0; i<str.length(); i++){
            if(!freq[i]) {
                freq[i] = true;
                result.addAll(permutation2(str, freq, ans + str.charAt(i)));
                freq[i] = false;
            }
        }

        return result;
    }

    //3rd approach, similar as 2nd approach but instead of using boolean map, we use swap and indices
    //abc -> abc, bac, cba swap 1st index with every other index character
    //swap 2nd index with every other greater index
    private static List<String> permutation3(String str, int i){
        List<String> result = new ArrayList<>();
        if(i == str.length()){
            result.add(str);
            return result;
        }

        for(int j = i; j<str.length();j++){
            str = swapCharacter(str, i, j);
            result.addAll(permutation3(str, i+1));
        }
        return result;
    }

    private static String swapCharacter(String str, int i, int j){
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
