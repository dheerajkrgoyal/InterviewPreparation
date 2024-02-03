package com.interview.ds.slidingwindow.variablewindow;

/**
 * Given a binary array nums and an integer k,
 * return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 */
public class MaxConsecutive1 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;

        System.out.println(maxOne(arr, k));
    }

    private static int maxOne(int[] arr, int k){
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int zeroCount = 0;
        while(right<arr.length){
            if(arr[right] == 0){
                zeroCount++;
            }

            while(left<=right && zeroCount>k){
                if(arr[left] == 0){
                    zeroCount--;
                }
                left++;
            }

            if(zeroCount<=k){
                max = Math.max(max, right-left+1);
            }
            right++;
        }

        return max;
    }


}
