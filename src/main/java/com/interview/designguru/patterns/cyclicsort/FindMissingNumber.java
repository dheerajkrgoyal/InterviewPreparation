package com.interview.designguru.patterns.cyclicsort;

/**
 * We are given an array containing n distinct numbers taken from the range 0 to n.
 * Since the array has only n numbers out of the total n+1 numbers, find the missing number.
 *
 * Input: [4, 0, 3, 1]
 * Output: 2
 *
 * Input: [8, 3, 5, 2, 4, 6, 0, 1]
 * Output: 7
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 3, 5, 2, 4, 6, 0, 1};
        System.out.println(findMissingNumber(arr));
    }

    public static int findMissingNumber(int[] nums) {
        int i = 0;
        //loop through each element
        while(i<nums.length){
            //since we have zero in the input each number will be in 0th index
            int correctIndex = nums[i];
            //if the element is already at the right index
            if(i == correctIndex){
                i++;
            }
            else{
                //the element is not at correct place but if the no. is going out of bound then ignore it
                if(correctIndex == nums.length){
                    i++;
                    continue;
                }
                //put the element at the right index
                //continue checking the right index for the element you have swapped with
                else{
                    int temp = nums[correctIndex];
                    nums[correctIndex] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        //return first index which doesn't have right element
        for( i = 0; i<nums.length; i++){
            if(i!=nums[i]){
                return i;
            }
        }
        //or else return the highest number
        return nums.length;
    }
}
