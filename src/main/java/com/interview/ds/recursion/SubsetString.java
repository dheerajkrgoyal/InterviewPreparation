package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetString {

    public static void main(String[] args) {
        System.out.println(subsetTail("abc", "", new ArrayList<>()));
    }

    private static List<String> subset(String str, String ans){
        List<String> result = new ArrayList<>();
        if(str.isEmpty()) {
            result.add(ans);
            return result;
        }

        result.addAll(subset(str.substring(1), ans));
        result.addAll(subset(str.substring(1), ans+str.charAt(0)));
        return result;
    }

    private static List<String> subsetTail(String str, String ans, List<String> result){
        if(str.isEmpty()){
            result.add(ans);
            return result;
        }

        subsetTail(str.substring(1), ans, result);
        subsetTail(str.substring(1), ans + str.charAt(0), result);
        return result;
    }

}
