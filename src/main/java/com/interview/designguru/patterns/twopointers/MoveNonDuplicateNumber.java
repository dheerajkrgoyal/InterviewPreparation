package com.interview.designguru.patterns.twopointers;

/**
 *  Given an array of sorted numbers, move all non-duplicate number instances at the beginning of the
 *  array in-place. The relative order of the elements should be kept the same and you should not use
 *  any extra space so that the solution has constant space complexity i.e., O(1).
 *
 * Move all the unique number instances at the beginning of the array and after moving return the
 * length of the subarray that has no duplicate in it.
 *
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after moving element will be [2, 3, 6, 9].
 *
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after moving elements will be [2, 11].
 */
public class MoveNonDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(moveNonDuplicate(new int[]{1,3,3,3,6,9,9}));
        System.out.println(moveNonDuplicate(new int[]{2,2,2,11}));
    }

    private static int moveNonDuplicate(int[] arr){
        int count = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[count] != arr[i]){
                arr[++count] = arr[i];
            }
        }
        return count+1;
    }
}
