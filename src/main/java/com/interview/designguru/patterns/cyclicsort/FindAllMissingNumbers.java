package com.interview.designguru.patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
 * The array can have duplicates, which means some numbers will be missing.
 * Find all those missing numbers.
 *
 * Input: [2, 3, 1, 8, 2, 3, 5, 1]
 * Output: 4, 6, 7
 * Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
 *
 * Input: [2, 4, 1, 2]
 * Output: 3
 *
 * Input: [2, 3, 2, 1]
 * Output: 4
 */
public class FindAllMissingNumbers {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,2,1};
        System.out.println(findNumbers(arr));
    }
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i = 0;
        //loop through each number in an array
        while(i<nums.length){

            //this is the correct index of the element
            int correctIndex = nums[i]-1;
            //if the element is already at correct index move on or we can check if in correct index
            //we have already placed right element
            //why prefer second condition because arr has duplicate element
            //if we have already processed once no need to do it again otherwise we may fall into
            //cyclic loop
            if(nums[correctIndex] == nums[i]){
                i++;
            }

            //if the element is not in its correct index put it at correct index
            //find the correct index for the element with which it was swapped in next loop
            else{
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            }
        }

        //find all numbers which are not at the correct index
        for(i = 0; i< nums.length; i++){
            if(nums[i] != i+1){
                missingNumbers.add(i+1);
            }
        }
        return missingNumbers;
    }
}
