package com.interview.designguru.patterns.cyclicsort;

/**
 * We are given an unsorted array containing n+1 numbers taken from the range 1 to n.
 * The array has only one duplicate but it can be repeated multiple times.
 * Find that duplicate number without using any extra space.
 * You are, however, allowed to modify the input array.
 *
 * Input: [1, 4, 4, 3, 2]
 * Output: 4
 *
 * Input: [2, 4, 1, 4, 4]
 * Output: 4
 *
 */
public class FindDuplicate {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 4, 4};
        System.out.println(findNumber(arr));
    }

    public static int findNumber(int[] nums) {
        int i = 0;
        while(i<nums.length){
            //if no. is already in the right position then move on
            if(nums[i] == i+1){
                i++;
            }
            //if no is not in the right position
            else{
                //in the correct index there is already a right element then we have found duplicate
                if(nums[i] == nums[nums[i]-1]){
                    return nums[i];
                }else{
                    //place the element in the right index
                    swap(nums, i, nums[i]-1);
                }
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
