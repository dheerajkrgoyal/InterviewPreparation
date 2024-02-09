package com.interview.designguru.patterns.twopointers;

import java.util.Arrays;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input
 * array in the sorted order.
 *
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 *
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 */
public class SquareSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(makeSquares(new int[]{-2,-1,0,2,3})));
    }

    public static int[] makeSquares(int[] arr) {
        int[] result = new int[arr.length];
        int left = 0;
        int right = arr.length-1;
        int i=arr.length-1;
        while(left<=right){
            if(Math.abs(arr[left])<=Math.abs(arr[right])){
                result[i--] = arr[right]*arr[right];
                right--;
            }
            else{
                result[i--] = arr[left]*arr[left];
                left++;
            }
        }
        return result;
    }
}
