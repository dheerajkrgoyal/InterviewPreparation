package com.interview.ds.binarysearch;

public class SquareRootOfANumber {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(sqrt(n));
    }

    private static int sqrt(int n){
        int low = 0;
        int high = n;
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid <= n/mid){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}
