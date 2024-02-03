package com.interview.ds.slidingwindow.variablewindow;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 2, 7, 1, 9};
        int k = 15;

        System.out.println(longestSubArray(arr, k));
    }

    private static int longestSubArray(int[] arr, int k){
        int maxLength = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right<arr.length){
            sum+=arr[right];
            while(left<=right && sum>k){
                sum-=arr[left];
                left++;
            }
            if(sum==k){
                maxLength = Math.max(maxLength, right-left+1);
            }
            right++;
        }
        return maxLength;
    }
}
