package com.interview.ds.slidingwindow.fixedwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumOfSubArraysSizeK {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maximum(arr, k)));
    }


    private static int[] maximum(int[] arr, int k){
        int[] res = new int[arr.length-k+1];
        int left = 0;
        int right = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        while(right<arr.length){
            while(!dq.isEmpty() && dq.peekLast()<=arr[right]){
                dq.pollLast();
            }
            dq.offer(arr[right]);
            while(right-left+1>k){
                if(!dq.isEmpty() && dq.peek() == arr[left]){
                    dq.poll();
                }
                left++;
            }
            if(right-left+1 == k){
                res[i++] = dq.peek();
            }
            right++;
        }
        return res;
    }
}
