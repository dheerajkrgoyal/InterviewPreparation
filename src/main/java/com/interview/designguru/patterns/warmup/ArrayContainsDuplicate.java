package com.interview.designguru.patterns.warmup;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
public class ArrayContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(containsDuplicate(arr));
        arr = new int[]{1,2,3,4,5};
        System.out.println(containsDuplicate(arr));
    }

    private static boolean containsDuplicate(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< arr.length; i++){
            if(set.contains(arr[i])){
                return true;
            }
            set.add(arr[i]);
        }

        return false;
    }
}
