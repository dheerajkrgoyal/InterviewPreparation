package com.interview.designguru.patterns.cyclicsort;

/**
 * Given an unsorted array containing numbers, find the smallest missing positive number in it.
 * Note: Positive numbers start from '1'.
 *
 * Input: [-3, 1, 5, 4, 2]
 * Output: 3
 * Explanation: The smallest missing positive number is '3'
 *
 * Input: [33, 37, 5]
 * Output: 1
 */
public class FindSmallestMissingPositiveNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{-3,1,5,4,2};
        System.out.println(findNumber(arr));
    }
    public static int findNumber(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i]>0 && nums[i]<nums.length && nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }
            else{
                i++;
            }
        }

        for(i = 0; i<nums.length; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return i+1;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
