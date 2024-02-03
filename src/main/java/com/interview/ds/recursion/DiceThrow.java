package com.interview.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class DiceThrow {

    public static void main(String[] args) {
        System.out.println(diceThrow(4, new ArrayList<>()));
        System.out.println(diceThrow2(4, new ArrayList<>()));
    }

    private static List<List<Integer>> diceThrow(int target, List<Integer> curr){
        List<List<Integer>> result = new ArrayList<>();
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return result;
        }
        for(int i = 1; i<=6; i++){
            if(i<=target){
                curr.add(i);
                result.addAll(diceThrow(target-i, curr));
                curr.remove(curr.size()-1);
            }
        }

        return result;
    }

    private static List<List<Integer>> diceThrow2(int target, List<Integer> list){
        List<List<Integer>> result = new ArrayList<>();
        if(target<0){
            return result;
        }

        if(target == 0){
            result.add(new ArrayList<>(list));
            return result;
        }

        for(int i = 1; i<=6; i++){
            list.add(i);
            result.addAll(diceThrow2(target-i, list));
            list.remove(list.size()-1);
        }

        return result;
    }
}
