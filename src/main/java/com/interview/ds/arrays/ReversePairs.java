package com.interview.ds.arrays;

public class ReversePairs {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,3,1};
        System.out.println(divide(arr, 0, arr.length - 1));
    }

    private static int divide(int[] nums, int start, int end){
        int count = 0;
        if(start>=end){
            return count;
        }
        int mid = start + (end-start)/2;
        count+= divide(nums, start, mid);
        count+= divide(nums, mid+1, end);
        count+= merge(nums, start, mid, end);
        return count;
    }

    private static int merge(int[] nums, int start, int mid, int end){
        int left = start;
        int right = mid+1;
        int count = 0;
        while(left<=mid){
            while(right<=end && nums[left]>2*nums[right]){
                right++;
            }
            count+= right-(mid+1);
            left++;
        }
        left = start;
        right = mid+1;
        int[] temp = new int[end-start+1];
        int k = 0;
        while(left<=mid && right<=end){
            if(nums[left]<nums[right]){
                temp[k++] = nums[left++];
            }
            else{
                temp[k++] = nums[right++];
            }
        }

        while(left<=mid){
            temp[k++] = nums[left++];
        }

        while(right<=end){
            temp[k++] = nums[right++];
        }

        for(int i = start; i<=end; i++){
            nums[i] = temp[i-start];
        }
        return count;
    }
}
