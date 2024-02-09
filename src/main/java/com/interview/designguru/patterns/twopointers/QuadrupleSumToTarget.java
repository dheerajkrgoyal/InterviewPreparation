package com.interview.designguru.patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it,
 * whose sum is equal to the target number.
 *
 *
 * Input: [2, 0, -1, 1, -2, 2], target=2
 * Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 */
public class QuadrupleSumToTarget {

    public static void main(String[] args) {
        System.out.println(quadruple(new int[]{2, 0, -1, 1, -2, 2}, 2));
    }

    private static List<List<Integer>> quadruple(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i<arr.length; i++){
            if(i>0 && arr[i-1] == arr[i]){
                continue;
            }
            for(int j = i+1; j<arr.length; j++){
                if(j>i+1 && arr[j-1] == arr[j]){
                    continue;
                }
                int left = j+1;
                int right = arr.length-1;
                while(left<right){
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if(sum<target){
                        left++;
                    }
                    else if(sum>target){
                        right--;
                    }
                    else{
                        result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;
                        while(left<right && arr[left-1] == arr[left]){
                            left++;
                        }
                        while(left<right && arr[right] == arr[right+1]){
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
