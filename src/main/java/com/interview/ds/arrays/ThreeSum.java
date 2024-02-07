package com.interview.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Find all the unique triplets in array which sums to zero
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-3, 0, 1, 2, -1, 1, -2};
        System.out.println(sum3(nums));
    }

    //use 3 pointers after sorting
    private static List<List<Integer>> sum3(int[] arr){
        List<List<Integer>> triplets = new ArrayList<>();

        //sort the array so that you can skip the duplicates
        Arrays.sort(arr);
        for(int i = 0; i<arr.length; i++){
            //when i >0 check if you used that i for same value then skip it
            if(i>0 && arr[i] == arr[i-1]){
                continue;
            }
            int left = i+1;
            int right = arr.length-1;
            while(left<right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum>0){
                    right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    //keep on skipping j and k similarly like i so that you dont get same triplet
                    while(left<right && arr[left]==arr[left-1]){
                        left++;
                    }

                    while(left<right && arr[right] == arr[right+1]){
                        right--;
                    }
                }
            }
        }
        return triplets;
    }
}
