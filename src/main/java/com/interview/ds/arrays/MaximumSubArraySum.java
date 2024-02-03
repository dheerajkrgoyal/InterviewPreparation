package com.interview.ds.arrays;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maxSum(arr));
    }

    //Kadanes Algorithm
    //if present sum is <0 do not take it forward because it will decrease the probable sum
    //if sum>0 take it forward, it will add up the value
    private static int maxSum(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i< arr.length; i++){
            sum+=arr[i];

            maxSum = Math.max(maxSum, sum);
            if(sum<0){
                sum = 0;
            }
        }
        return maxSum;
    }
}
