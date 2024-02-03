package com.interview.ds.binarysearch;

import java.util.Arrays;

/**
 * to find the first occurrence, once we find the element, we keep on pushing to left to see where can we push
 * the boundary, similarly to fin the last occurrence we keep on pushing to the right to see where we can push the
 * boundary.
 *
 * These questions can come in many form like
 * implement lower bound
 * implement upper bound
 * search insert position
 * floor/ceil in sorted array
 * count total no. of occurrences in sorted array with duplicates
 */
public class FirstAndLastOccurrenceOfElement {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,2,2,2,2};
        int x = 2;
        int first = firstOccurrence(arr, x);
        int[] res = new int[]{-1,-1};
        if(first == -1){
            System.out.println(Arrays.toString(res));
        }
        else{
            res[0] = first;
            res[1] = lastOccurrence(arr, x);
            System.out.println(Arrays.toString(res));
        }
    }

    private static int firstOccurrence(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == x){
                ans = mid;
                high = mid-1;
            }
            else if(arr[mid]<x){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    private static int lastOccurrence(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == x){
                ans = mid;
                low = mid+1;
            }
            else if(arr[mid]<x){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}
