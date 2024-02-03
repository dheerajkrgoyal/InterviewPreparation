package com.interview.ds.binarysearch;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and
 * eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will
 * not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] piles = new int[]{3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(speed(mid, h, piles)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static int max(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    private static boolean speed(int k, int h, int[] piles){
        int hour = 0;
        for(int i = 0; i<piles.length; i++){
            hour += piles[i]/k;
            if(piles[i] %k != 0){
                hour++;
            }
            if(hour>h){
                return false;
            }
        }
        return hour<=h;
    }
}
