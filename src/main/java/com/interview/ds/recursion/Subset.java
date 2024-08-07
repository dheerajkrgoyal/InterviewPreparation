package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
//        subset(new int[]{1, 2, 3}, 0, new ArrayList<>(), result);
        result = subsetIteration(new int[]{1,2,3});
        System.out.println(result);
    }

    private static List<List<Integer>> subsetIteration(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i<arr.length; i++){
            int size = result.size();
            for(int j = 0; j<size; j++){
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(arr[i]);
                result.add(list);
            }
        }
        return result;
    }

    //non-tail
    @SuppressWarnings("unused")
    private static List<List<Integer>> subset(int[] arr, int i, List<Integer> currentList){
        List<List<Integer>> result = new ArrayList<>();
        if(i == arr.length){
            result.add(new ArrayList<>(currentList));
            return result;
        }

        //dont-pick
        result.addAll(subset(arr, i+1, currentList));

        //pick
        currentList.add(arr[i]);
        result.addAll(subset(arr, i+1, currentList));
        currentList.remove(currentList.size()-1); //backtracking for subsequent recursions
        return result;
    }

    //tail
    @SuppressWarnings("unused")
    private static void subset(int[] arr, int i, List<Integer> currentList, List<List<Integer>> result){
        if(i==arr.length){
            result.add(new ArrayList<>(currentList));
            return;
        }

        subset(arr, i+1, currentList, result);
        currentList.add(arr[i]);
        subset(arr, i+1, currentList, result);
        currentList.remove(currentList.size()-1);
    }

}
