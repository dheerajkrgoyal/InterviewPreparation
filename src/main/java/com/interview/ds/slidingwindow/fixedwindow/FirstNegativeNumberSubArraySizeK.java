package com.interview.ds.slidingwindow.fixedwindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumberSubArraySizeK {
    public static void main(String[] args) {
        int[] arr = new int[]{5,-3,2,3,-4};
        int k = 2;
        System.out.println(Arrays.toString(negative(arr, k)));
    }

    private static int[] negative(int[] arr, int k){
        Queue<Integer> negatives = new LinkedList<>();
        int left = 0;
        int right = 0;
        int[] res = new int[arr.length-k+1];
        int i = 0;
        while(right<arr.length){
            if(arr[right]<0){
                negatives.offer(arr[right]);
            }

            while (right-left+1 >k){
                if(!negatives.isEmpty() && negatives.peek() ==  arr[left]){
                    negatives.poll();
                }
                left++;
            }

            if(right-left+1 == k){
                if(!negatives.isEmpty())
                    res[i++] = negatives.peek();
                else{
                    res[i++] = 0;
                }
            }
            right++;
        }
        return res;
    }
}
