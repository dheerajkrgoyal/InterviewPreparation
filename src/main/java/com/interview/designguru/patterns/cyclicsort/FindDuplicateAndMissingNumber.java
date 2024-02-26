package com.interview.designguru.patterns.cyclicsort;

public class FindDuplicateAndMissingNumber {

    public int[] findNumbers(int[] nums) {
        int[] output = new int[2];
        int i = 0;
        while(i<nums.length){
            //if element is at the right index move on
            if(nums[i] == i+1){
                i++;
            }
            else{
                //if element is not at right index and the right index already have that element then its duplicate
                if(nums[i] == nums[nums[i]-1]){
                    output[0] = nums[i];
                    i++;
                }
                else{
                    //swap the element if not in the right index
                    swap(nums, i, nums[i]-1);
                }
            }
        }

        //loop through array to check all elements are on right index of not we have found missing element
        for(i = 0; i<nums.length; i++){
            if(nums[i] != i+1){
                output[1] = i+1;
            }
        }
        return output;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
