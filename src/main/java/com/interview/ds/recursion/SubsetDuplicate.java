package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetDuplicate {

    public static void main(String[] args) {
//        System.out.println(subsetIteration(new int[]{2, 1, 2}));
        int[] arr = new int[]{2,1,2};
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        subsetRecursion(arr, 0, new ArrayList<>(), result);
        System.out.println(result);
    }

    @SuppressWarnings("unused")
    private static List<List<Integer>> subsetIteration(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int start = 0;
        int end = 0;
        result.add(new ArrayList<>());
        for(int i = 0; i< arr.length; i++){
            start = 0;
            if(i>0 && arr[i] == arr[i-1]) {
                start = end +1;
            }
            end = result.size()-1;
            for(int j = start; j<= end; j++){
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(arr[i]);
                result.add(list);
            }
        }

        return result;
    }

    private static void subsetRecursion(int[] arr, int i, List<Integer> curr, List<List<Integer>> result){
        if(i == arr.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        //pick it
        curr.add(arr[i]);
        subsetRecursion(arr, i +1, curr, result);

        //skip it
        curr.remove(curr.size()-1);
        while(i+1<arr.length && arr[i] == arr[i+1]){
            i++; //skip all repeating no.
        }
        subsetRecursion(arr, i+1, curr, result);
    }
}
