package com.interview.ds.binarysearch;

/**
 * A conveyor belt has packages that must be shipped from one port to another within d days.
 *
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages
 * on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight
 * capacity of the ship.
 *
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt
 * being shipped within d days.
 */
public class ShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        System.out.println(shipWithinDays(arr, D));

    }
    public static int shipWithinDays(int[] weights, int days) {
        int low  = max(weights);
        int high = sum(weights);

        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(canShip(mid, weights, days)){
                ans = mid;
                high = mid-1;
            }

            else{
                low = mid+1;
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
        for(int i = 0; i< arr.length; i++){
            sum+=arr[i];
        }

        return sum;
    }

    private static boolean canShip(int maxWeight, int[] weights, int days){
        int d = 1;
        int sum = 0;
        for(int i = 0; i<weights.length; i++){
            sum+=weights[i];
            if(sum>maxWeight){
                d++;
                sum = weights[i];
                if(d>days){
                    return false;
                }
            }
        }
        return true;
    }
}
