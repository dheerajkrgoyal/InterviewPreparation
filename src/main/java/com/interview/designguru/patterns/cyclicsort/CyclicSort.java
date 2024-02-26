package com.interview.designguru.patterns.cyclicsort;

import java.util.Arrays;

/**
 * Given unsorted array of length n and all the element ranges from 1..n, sort the array in-place
 *
 * Input: [2, 6, 4, 3, 1, 5]
 * Output: [1, 2, 3, 4, 5, 6]
 *
 * Input: [1, 5, 6, 4, 3, 2]
 * Output: [1, 2, 3, 4, 5, 6]
 */
public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 6, 4, 3, 2};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] nums) {
        int i = 0;
        //loop through every element in the array
        while(i<nums.length){
            //check what is the correct index of the current element
            int correctIndex = nums[i]-1;
            //if the element is already in the correct index do nothing and move forward
            if(i == correctIndex){
                i++;
            }
            //if the element is not in the correct index, put the element in correct index and
            //put other element in the current index and repeat operation
            else{
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }
        }
        //do this for all element, at the end all elements will be at their correct index
        return nums;
    }
}
