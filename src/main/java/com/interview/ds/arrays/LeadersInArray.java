package com.interview.ds.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leader is element whose all the right elements are smaller
public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{10,22,12,3,0,6};
        System.out.println(Arrays.toString(leaders(arr)));
    }

    //start from the end and keep track of max
    //if current element is greater than max it qualifies to be leader
    private static Integer[] leaders(int[] arr){
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i]>max){
                res.add(arr[i]);
                max = arr[i];
            }
        }


        return res.toArray(new Integer[res.size()]);
    }
}
