package com.interview.ds.arrays;


//all positive -> whole array is max
//even negatives -> becomes +ve
//odd negatives -> becomes -ve , ignore 1 -ve to make it +ve
//if it has zero stat=rt again after that element

//multiply no from start and end and check max at each time but when
// multiplication becomes 0 start from 1 again

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 3, 4, -1, 0, -2, 3, 1, 4, 0, 4, 6, -1, 4};
        System.out.println(calculate(arr));
    }

    private static int calculate(int[] arr){
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            prefix *= arr[i];
            suffix *= arr[arr.length-1-i];
            max = Math.max(max, Math.max(prefix, suffix));
            if(prefix == 0)
                prefix =1;
            if(suffix == 0)
                suffix = 1;
        }

        return max;
    }
}
