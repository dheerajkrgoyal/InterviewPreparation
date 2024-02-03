package com.interview.ds.arrays;

import java.util.Arrays;

public class RearrangePositiveNegative {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,-2,-5,2,-4};

        shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shuffle(int[] arr){
        int[] pos = new int[arr.length/2];
        int[] neg = new int[arr.length/2];
        int posi = 0;
        int negi = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] <0){
                neg[negi++] = arr[i];
            }
            else{
                pos[posi++] = arr[i];
            }
        }

        for(int i = 0; i<pos.length; i++){
            arr[i*2] = pos[i];
            arr[i*2+1] = neg[i];
        }

        /**
         *         int[] ans = new int[nums.length];
         *         int posi = 0;
         *         int negi = 1;
         *         for(int i=0; i<nums.length; i++){
         *             if(nums[i] >0){
         *                 ans[posi] = nums[i];
         *                 posi+=2;
         *             }
         *             else{
         *                 ans[negi] = nums[i];
         *                 negi+=2;
         *             }
         *         }
         *         return ans;
         */
    }
}
