package com.interview.ds.binarysearch;

import java.util.Arrays;
import java.util.List;

/**
 * Given arr, arr[i] represents the number of pages in the ith book
 * there are m students and the task is to allocate all the books to the students
 * Allocate books in such a way that
 * 1. each student gets at least one book
 * 2. each book should be allocated to only one student
 * 3. book allocation should be in contiguous manner
 *
 * allocate books to m students such that maximum number of pages assigned to a student is minimised.
 * if allocation is not possible return -1;
 */

public class BookAllocation {
    public static void main(String[] args) {
        List<Integer> books = Arrays.asList(new Integer[]{12,34,67,90});
        int students = 2;
        System.out.println(findPages(books, students));
    }

    public static int findPages(List<Integer> arr, int m) {
        // Write your code here.
        int low = max(arr);
        int high = sum(arr);
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(possible(mid, arr, m)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }


    private static int max(List<Integer> arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.size(); i++){
            max = Math.max(max, arr.get(i));
        }
        return max;
    }

    private static int sum(List<Integer> arr){
        int sum = 0;
        for(int i = 0; i<arr.size(); i++){
            sum+= arr.get(i);
        }

        return sum;
    }

    private static boolean possible(int maxPage, List<Integer> books, int students){
        int s =1;
        int page = 0;
        for(int i = 0; i<books.size(); i++){
            if(page + books.get(i)<=maxPage){
                page+= books.get(i);
            }
            else{
                s++;
                page = books.get(i);
                if(s>students){
                    return false;
                }
            }
        }
        return true;
    }
}
