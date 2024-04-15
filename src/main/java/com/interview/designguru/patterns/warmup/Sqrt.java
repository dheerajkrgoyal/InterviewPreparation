package com.interview.designguru.patterns.warmup;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.8284, and since we need to return the floor of the square
 * root (integer), hence we returned 2.
 *
 * Input: x = 2
 * Output: 1
 * Explanation: The square root of 2 is 1.414,
 * and since we need to return the floor of the square root (integer), hence we returned 1.
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(8));
        System.out.println(sqrt(2));
        System.out.println(sqrt(4));
        System.out.println(sqrt(0));
    }

    private static int sqrt(int x){
        if(x == 0){
            return 0;
        }

        int low = 1;
        int high = x;
        int ans = 1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid <= x/mid){
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
