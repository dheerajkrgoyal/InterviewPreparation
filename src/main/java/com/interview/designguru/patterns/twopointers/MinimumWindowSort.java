package com.interview.designguru.patterns.twopointers;

/**
 * Given an array, find the length of the smallest subarray in it which when sorted
 * will sort the whole array.
 *
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 *
 * Input: [1, 3, 2, 0, -1, 7, 10]
 * Output: 5
 * Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 */
public class MinimumWindowSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 3, 7, 10, 9, 12};
        System.out.println(sort(arr));

        arr = new int[]{1, 3, 2, 0, -1, 7, 10};
        System.out.println(sort(arr));
    }

    public static int sort(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        //trying to find the starting position when array is not sorted
        while(low<arr.length-1 && arr[low]<=arr[low+1]){
            low++;
        }
        //array is sorted
        if(low == arr.length-1){
            return 0;
        }

        //trying to find the last position when array is not sorted
        while(high>0 && arr[high]>=arr[high-1]){
            high--;
        }

        //there could be more numbers outside low, high subarray which could fall under unsorted

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = low; i<=high; i++){
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }

        //if there are number which are greater than min of subarray on the left
        //should be taken into condieration
        while(low>0 && arr[low-1]>min){
            low--;
        }

        //similarly if there are number which are lesser than max of subarray on the right
        //should be taken into consideration
        while(high<arr.length-1 && arr[high+1]<max){
            high++;
        }


        return high-low+1;
    }
}
