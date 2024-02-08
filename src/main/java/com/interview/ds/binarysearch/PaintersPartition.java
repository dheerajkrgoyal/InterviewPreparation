package com.interview.ds.binarysearch;

/**
 * given an arr represents board and each element represents the length of each board.
 * some k painters are given to paint these boards. consider each unit of board takes 1 unit of
 * time to paint. you are supposed to return the minimum time to get this job done of painting
 * all the boards under a constraint that any painter will only paint the continuous sections of
 * the board.
 *
 * similar problem : split array such that largest sum of the sub-array is minimised.
 */
public class PaintersPartition {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};
        int painters = 2;
        System.out.println(minimumTime(arr, painters));
    }

    private static int minimumTime(int[] arr, int painters){
        int low = max(arr);
        int high = sum(arr);
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(possible(mid, arr, painters)){
                ans = mid;
                high = mid-1;
            }
            else{
                low =  mid+1;
            }
        }
        return ans;
    }

    private static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private static int sum(int[] arr){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }

    private static boolean possible(int maxTime, int[] arr, int painters){
        int p = 1;
        int t = 0;
        for(int i = 0; i<arr.length; i++){
            if(t+arr[i] <=maxTime){
                t+=arr[i];
            }
            else{
                p++;
                t = arr[i];
                if(p>painters){
                    return false;
                }
            }
        }
        return true;
    }
}

