package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        System.out.println(permutation("abc", ""));
        System.out.println(permutationCount("abc", ""));
    }

    private static List<String> permutation(String s, String ans){
        List<String> result = new ArrayList<>();
        if(s.length() == 0){
            result.add(ans);
            return result;
        }

        char ch = s.charAt(0);
        for(int i = 0; i<=ans.length(); i++){
            String si = ans.substring(0, i) + ch + ans.substring(i);
            result.addAll(permutation(s.substring(1), si));
        }
        return result;
    }

    private static int permutationCount(String s, String ans){
        int count = 0;
        if(s.isEmpty()){
            return 1;
        }

        char ch = s.charAt(0);
        for(int i = 0; i<=ans.length(); i++){
            String si = ans.substring(0,i) + ch + ans.substring(i);
            count += permutationCount(s.substring(1), si);
        }
        return count;
    }
}
