package com.interview.designguru.patterns.twopointers;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum
 * is as close to the target number as possible, return the sum of the triplet. If there are more
 * than one such triplet, return the sum of the triplet with the smallest sum.
 *
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: The triplet [-1, 0, 3] has the sum '2' which is closest to the target.
 *
 * There are two triplets with distance '1' from the target: [-1, 0, 3] & [-1, 2, 3].
 * Between these two triplets, the correct answer will be [-1, 0, 3] as it has a sum '2' which is
 * less than the sum of the other triplet which is '4'. This is because of the following requirement:
 * 'If there are more than one such triplet, return the sum of the triplet with the smallest sum.'
 *
 * Input: [0, 0, 1, 1, 2, 6], target=5
 * Output: 4
 * Explanation: There are two triplets with distance '1' from target: [1, 1, 2] & [0, 0, 6].
 * Between these two triplets, the correct answer will be [1, 1, 2] as it has a sum '4' which is
 * less than the sum of the other triplet which is '6'. This is because of the following requirement:
 * 'If there are more than one such triplet, return the sum of the triplet with the smallest sum.'
 */
public class TripletCloseToTarget {

    public static void main(String[] args) {

        System.out.println(searchTriplet(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(searchTriplet(new int[]{0, 0, 1, 1, 2, 6}, 5));

    }

    private static  int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            int left = i+1;
            int right = arr.length-1;
            while(left<right){
                int sum = arr[i] + arr[left] + arr[right];
                //if diff is 0 then just return the target sum
                if(sum == targetSum){
                    return targetSum;
                }
                else{
                    //if mindiff is exactly same we check if sum is minimum or not
                    if(minDiff == Math.abs(sum-targetSum)){
                        minSum = Math.min(minSum, sum);
                    }
                    //if new diff is smaller we update the min diff and sum
                    if(minDiff>Math.abs(sum-targetSum)){
                        minDiff = Math.abs(sum-targetSum);
                        minSum = sum;
                    }
                    if(sum<targetSum){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return minSum;
    }
}
